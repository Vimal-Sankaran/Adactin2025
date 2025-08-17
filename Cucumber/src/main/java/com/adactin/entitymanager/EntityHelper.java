package com.adactin.entitymanager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EntityHelper {

    public static List<BookingData> readJsonFile() {
        String jsonPath = "C:\\Users\\pavi\\IdeaProjects\\Adactin2025\\Cucumber\\src\\test\\resources\\data\\BookingData.json";
        ObjectMapper objectMapper = new ObjectMapper();
        List<BookingData> bookingDataList = null;

        try {
            bookingDataList = objectMapper.readValue(new File(jsonPath), new TypeReference<List<BookingData>>() {
            });
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return bookingDataList;
    }

    private final List<BookingData> bookingDataList = readJsonFile();
    public BookingData getCustomerDataById(String id) {
        BookingData data = bookingDataList.stream().filter(c->c.getId().equals(id)).findAny().orElse(null);
        return data;
    }


    public void saveBookingData() {
        String jsonPath = "D:\\TestingB\\Cucumber\\src\\test\\resources\\data\\BookingData.json";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonPath), bookingDataList);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write updated booking data to JSON", e);
        }
    }

}
