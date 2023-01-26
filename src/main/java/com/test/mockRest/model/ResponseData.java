package com.test.mockRest.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(builder = ResponseData.ResponseDataBuilder.class)
public class ResponseData {
    RestResponseStatus result;
    Object data;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ResponseDataBuilder {
    }
}
