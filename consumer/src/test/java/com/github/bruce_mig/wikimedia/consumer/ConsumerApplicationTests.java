package com.github.bruce_mig.wikimedia.consumer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.github.bruce_mig.wikimedia.consumer.WikiEventTestDataProviderUtils.supplyWikiEvent;
import static org.awaitility.Awaitility.await;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class ConsumerApplicationTests extends AbstractContainerProviderConfig {

	@Value("${topic.name}")
	private String wikimediaStream;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Test
	public void testConsumeMsg(){
		log.info("testConsumeMsg method execution started");
		String msg = supplyWikiEvent();
		kafkaTemplate.send(wikimediaStream, msg);
		log.info("testConsumeMsg method execution ended...");
		await().pollInterval(Duration.ofSeconds(3))
				.atMost(10, TimeUnit.SECONDS)
				.untilAsserted(() -> {
					// asset statement
				});
	}

}
