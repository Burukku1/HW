package com.dmitry.code.epamlab.controllers;

import com.dmitry.code.epamlab.exception.InternalServerError;
import com.dmitry.code.epamlab.exception.InvalidURLException;
import com.dmitry.code.epamlab.model.Fibonachi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.json.JSONObject;

@RestController
public class HelloController {

    private static Logger logger = LogManager.getLogger();

    @GetMapping("/fibonachi")
    public ResponseEntity<Integer> fibon(@RequestParam("number") int number) throws InternalServerError, InvalidURLException {

        logger.info("Connect to localhost:8080/fibonachi?number=?");

        Fibonachi num = new Fibonachi();

        num.setNumber(number);


        num.validate();

        logger.info("Calculate");
        int answer = num.calculate();
        return ResponseEntity.ok(answer);
    }

}
