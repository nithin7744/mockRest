package com.test.mockRest.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(builder = RestResponseStatus.RestResponseStatusBuilder.class)
public class RestResponseStatus {
    String errNo;
    String errMsg;


    @JsonPOJOBuilder(withPrefix = "")
    public static class RestResponseStatusBuilder {
    }
}
