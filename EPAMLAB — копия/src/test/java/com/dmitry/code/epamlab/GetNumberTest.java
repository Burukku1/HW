package com.dmitry.code.epamlab;

import com.dmitry.code.epamlab.controllers.HelloController;
import com.dmitry.code.epamlab.exception.InternalServerError;
import com.dmitry.code.epamlab.exception.InvalidURLException;
import com.dmitry.code.epamlab.model.Fibonachi;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class GetNumberTest {
    @Test
    void testCalculatee() throws InvalidURLException, InternalServerError {
        Fibonachi fibonachi = new Fibonachi();
        fibonachi.setNumber(20);
        HelloController helloController = new HelloController();

        ResponseEntity<Integer> responseEntity = helloController.fibon(fibonachi.getNumber());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(fibonachi.calculate(), responseEntity.getBody());
    }

    @Test
    void testCalculateInvalidInput() throws InvalidURLException, InternalServerError {
        Fibonachi fibonachi = new Fibonachi();
        fibonachi.setNumber(-2);
        HelloController helloController = new HelloController();

        ResponseEntity<Integer> responseEntity = helloController.fibon(fibonachi.getNumber());
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    @Test
    void testCalculateInternalError() throws InvalidURLException, InternalServerError {
        Fibonachi fibonachi = new Fibonachi(1000000);
        HelloController helloController = new HelloController();

        ResponseEntity<Integer> responseEntity = helloController.fibon(fibonachi.getNumber());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());

    }
}