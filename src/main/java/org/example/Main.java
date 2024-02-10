package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.IOException;


public class Main
{
    public static void main(String[] args)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        Player player = new Player(new Point(0, 10), "Игрок");
        Magician magician = new Magician(new Point(20, 15), "Волшебник");
        String result;

        try {
            result = objectMapper.writeValueAsString(magician);
            System.out.println(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        try {
            Magician newMagician = objectMapper.readValue(result, Magician.class);
            System.out.println(comparison(magician, newMagician) ? "Ну так то заебись" : "чёта хуйня пошла");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean comparison(Entity one, Entity two)
    {

        if (!one.name.equals(two.name))
            return false;
        else if (!one.worldPosition.equals(two.worldPosition))
            return false;
        else if (one.movementSpeed != two.movementSpeed)
            return false;

        return true;
    }
}