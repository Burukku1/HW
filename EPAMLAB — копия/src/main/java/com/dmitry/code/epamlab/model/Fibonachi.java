package com.dmitry.code.epamlab.model;

import com.dmitry.code.epamlab.exception.InternalServerError;
import com.dmitry.code.epamlab.exception.InvalidURLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Fibonachi {
    private int number;

    public Fibonachi(int number) {
        this.number = number;
    }

    public Fibonachi() {

    }

    public int calculate() {
        int first = 1;
        int second = 1;
        int third = 0;

        for (int i = 2; i <= number; i++) {
            third = first + second;
            first = second;
            second = third;
        }

        return third;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public void validate() throws InvalidURLException, InternalServerError {
        Logger logger = LogManager.getLogger();
        if (number < 0) {
            logger.info("<0");
            throw new InvalidURLException("<0");
        } else if (number > 100000) {
            logger.info(">100000");
            throw new InternalServerError(">100000");
        }
    }

}
