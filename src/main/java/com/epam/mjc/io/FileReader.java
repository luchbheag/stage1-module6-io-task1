package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                sb.append((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] pairsOfData = sb.toString().split("\n");
        String name = getValueFromPair(pairsOfData[0]);
        int age = Integer.valueOf(getValueFromPair(pairsOfData[1]));
        String email = getValueFromPair(pairsOfData[2]);
        long phone = Long.valueOf(getValueFromPair(pairsOfData[3]));

        return new Profile(name, age, email, phone);
    }

    private String getValueFromPair(String pair) {
        return pair.split(":")[1].trim();
    }
}
