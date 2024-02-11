package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;


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



        ArrayList<Entity> arrayMagician = new ArrayList<>();
        for (int i = 0; i < 5; ++i)
            arrayMagician.add(new Magician(new Point((int) (Math.random() * i), (int) (Math.random() * i)), "маг №" + i));
        try {
            result = objectMapper.writeValueAsString(arrayMagician);
            objectMapper.writeValue(new File("target/arrayMagician.json"), arrayMagician);
            System.out.println(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File file = new File("target/arrayMagician.json");

        try {
            ArrayList<Magician> list = objectMapper.readValue(file, new TypeReference<ArrayList<Magician>>(){});
            for (int i = 0; i < list.size(); ++i)
                System.out.println(comparison(arrayMagician.get(i), list.get(i)));
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