package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player extends Entity
{
    private final ArrayList<String> messages = new ArrayList<>();
    private final Map<Direction, ArrayList<BufferedImage>> animations = new HashMap<>();
    private Direction direction = Direction.Up;

    public Player(Point worldPosition, String name)
    {
        super(worldPosition, name);

        for (int i = 0; i < 5; ++i)
            messages.add("всякий пиздешь плеера №" + i);

        try
        {
            loadAnimations(Direction.Up);
            loadAnimations(Direction.Down);
            loadAnimations(Direction.Left);
            loadAnimations(Direction.Right);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }



    public ArrayList<String> getMessages() {
        return messages;
    }

    public Map<Direction, ArrayList<BufferedImage>> getAnimations() {
        return animations;
    }

    private void loadAnimations(Direction direction) throws IOException
    {
        ArrayList<BufferedImage> list = new ArrayList<>();

        switch (direction)
        {
            case Up:
                list.add(ImageIO.read(new File("src/assets/Player/up1.png")));
                list.add(ImageIO.read(new File("src/assets/Player/up2.png")));
                list.add(ImageIO.read(new File("src/assets/Player/up3.png")));
                list.add(ImageIO.read(new File("src/assets/Player/up4.png")));
                animations.put(Direction.Up, list);
                break;
            case Down:
                list.add(ImageIO.read(new File("src/assets/Player/down1.png")));
                list.add(ImageIO.read(new File("src/assets/Player/down2.png")));
                list.add(ImageIO.read(new File("src/assets/Player/down3.png")));
                list.add(ImageIO.read(new File("src/assets/Player/down4.png")));
                animations.put(Direction.Up, list);
                break;
            case Left:
                list.add(ImageIO.read(new File("src/assets/Player/left1.png")));
                list.add(ImageIO.read(new File("src/assets/Player/left1.png")));
                list.add(ImageIO.read(new File("src/assets/Player/left1.png")));
                list.add(ImageIO.read(new File("src/assets/Player/left1.png")));
                animations.put(Direction.Up, list);
                break;
            case Right:
                list.add(ImageIO.read(new File("src/assets/Player/right1.png")));
                list.add(ImageIO.read(new File("src/assets/Player/right1.png")));
                list.add(ImageIO.read(new File("src/assets/Player/right1.png")));
                list.add(ImageIO.read(new File("src/assets/Player/right1.png")));
                animations.put(Direction.Up, list);
                break;

        }
    }
}
