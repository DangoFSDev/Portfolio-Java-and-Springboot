package com.ecos.application.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponse {

    private String status;
    private String message;

    public static ErrorResponse instantiate(String message) {

        return ErrorResponse.builder()
                            .status("error")
                            .message(message)
                            .build();
    }

    public static ErrorResponse instantiate(String status, String message) {

        return ErrorResponse.builder()
                            .status(status)
                            .message(message)
                            .build();
    }

}
