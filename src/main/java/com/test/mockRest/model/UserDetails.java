package com.test.mockRest.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
@JsonDeserialize(builder = UserDetails.UserDetailsBuilder.class)
public class UserDetails {
    Map<String, Object> userDtls;

    @JsonPOJOBuilder(withPrefix = "")
    public static class UserDetailsBuilder {
    }
}
