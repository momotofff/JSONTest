package org.example;

import java.awt.*;

public class Entity
{
    public Point worldPosition;
    public int movementSpeed;
    public String name;

    public Entity(Point worldPosition, String name)
    {
        this.worldPosition = worldPosition;
        this.name = name;
        movementSpeed = 2;
    }

    public  Entity()
    {

    }
}
