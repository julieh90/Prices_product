package com.prices.prices.commons.exception;

import com.prices.prices.commons.domains.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
@Data
public class PricesRuntimeException extends RuntimeException {
    private final ErrorCode code;

    public PricesRuntimeException(ErrorCode code) {
        super(code.getMessage());
        this.code = code;
    }

    public PricesRuntimeException(ErrorCode code, Throwable cause) {
        super(code.getMessage(), cause);
        this.code = code;
    }

    public PricesRuntimeException(String message) {
        super(message);
        this.code = null;
    }
}

