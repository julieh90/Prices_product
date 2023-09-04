package com.prices.prices.commons.exception;

import com.prices.prices.commons.domains.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class NoContentException extends PricesRuntimeException {
    public NoContentException(ErrorCode code) {
        super(code);
    }

}
