package com.prices.prices.commons.domains;

import lombok.Getter;


    @Getter
    public enum ErrorCode {

        DATA_NOT_FOUND("data not found");

        private final String message;

        ErrorCode(String message) {
            this.message = message;
        }

    }

