package com.github.bruce_mig.wikimedia.payload;

import lombok.*;

import java.util.List;

@Data
@Builder
public class WikiEvent {

    private String event;
    private List<EventId> id;
    private EventData data;
}
