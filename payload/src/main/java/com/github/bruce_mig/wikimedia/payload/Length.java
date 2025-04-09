package com.github.bruce_mig.wikimedia.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Length {

    private Integer old;

    @JsonProperty("new")
    private Integer neW;
}
