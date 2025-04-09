package com.github.bruce_mig.wikimedia.payload;

import lombok.*;

@Data
@Builder
public class EventId {

    private String topic;
    private Integer partition;
    private Integer timestamp;
    private Integer offset;
}
