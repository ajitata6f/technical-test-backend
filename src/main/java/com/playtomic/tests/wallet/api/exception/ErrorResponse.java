package com.playtomic.tests.wallet.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ErrorResponse {

    private int status;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("errors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> fieldErrors = new HashMap<>();

    public void addError(String field, String message) {
        fieldErrors.put(field, message);
    }

}
