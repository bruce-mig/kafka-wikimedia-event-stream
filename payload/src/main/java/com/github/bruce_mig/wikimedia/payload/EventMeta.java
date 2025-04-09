package com.github.bruce_mig.wikimedia.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventMeta {
    private String uri;
    @JsonProperty("request_id")
    private String requestId;
    private String id;
    private String dt;
    private String domain;
    private String stream;
    private String topic;
    private Integer partition;
    private Integer offset;
}
