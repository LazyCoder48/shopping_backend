package com.shop.extras;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.model.Product;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ObjectToJson {

    public static void main(String[] args) {

        try {
            String json = new ObjectMapper().writeValueAsString(new Product());
            log.info(json);
        } catch (JsonProcessingException e) {
            log.error("Error while parsing " + e.getMessage(), e);
        }

    }

}
