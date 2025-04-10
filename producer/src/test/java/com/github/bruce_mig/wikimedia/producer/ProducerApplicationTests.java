package com.github.bruce_mig.wikimedia.producer;

import com.github.bruce_mig.wikimedia.producer.producer.WikimediaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.github.bruce_mig.wikimedia.producer.WikiEventTestDataProviderUtils.supplyWikiEvent;
import static org.awaitility.Awaitility.await;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProducerApplicationTests extends AbstractContainerProviderConfig {

	@Autowired
	private WikimediaProducer producer;

	@Test
	public void testSendMessage(){
		String msg = supplyWikiEvent();
		producer.sendMessage(msg);
		await().pollInterval(Duration.ofSeconds(3))
				.atMost(10, TimeUnit.SECONDS)
				.untilAsserted(() -> {
					// asset statement
				});

	}

}
