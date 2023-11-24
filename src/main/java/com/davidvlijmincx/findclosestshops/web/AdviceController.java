package com.davidvlijmincx.findclosestshops.web;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;



@ControllerAdvice
public class AdviceController {

    private static final Logger logger = LoggerFactory.getLogger(AdviceController.class);

    @ExceptionHandler(LatitudeNotValid.class)
    ErrorResponse LatitudeNotValid(LatitudeNotValid e) {
        logger.error("An LatitudeNotValid has happened");
        return ErrorResponse.builder(e, HttpStatusCode.valueOf(400), "Latitude is not valid! Should be between -90 and 90 and was %s".formatted(e.getLatitude()))
                .build();
    }


    @ExceptionHandler(LongitudeNotValid.class)
    ErrorResponse LongitudeNotValid(LongitudeNotValid e) {
        logger.error("An LongitudeNotValid has happened");
        return ErrorResponse.builder(e, HttpStatusCode.valueOf(400), "LongitudeNotValid is not valid! Should be between -180 and 180 and was %s".formatted(e.getLongitude()))
                .build();
    }

}
