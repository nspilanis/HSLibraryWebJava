package com.internetq.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.internetq.model.Card;
import com.internetq.model.Cards;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @author n.spilanis
 * @version 1.0
 * @since 29/7/2016
 */

@Service
public class ContentService {

    public List<Card> getData() {

        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Cards cardsObject = null;

        try {
            HttpResponse<Cards> response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards")
                    .header("X-Mashape-Key", "B2Y4D5cEFqmshsh7JC1BzMbMkOwGp1gkaxTjsnl991QHj6iHUl")
                    .asObject(Cards.class);

            cardsObject = response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return cardsObject == null ? new ArrayList<Card>() : cardsObject.cards;
    }
}
