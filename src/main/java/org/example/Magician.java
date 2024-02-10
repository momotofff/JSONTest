package org.example;

import java.awt.*;
import java.util.ArrayList;

public class Magician extends Entity
{
    private final ArrayList<String> dialogues = new ArrayList<>();

    public Magician(Point worldPosition, String name)
    {
        super(worldPosition, name);

        for (int i = 0; i < 10; ++i)
            dialogues.add("Строка диалога №" + i);
    }

    public Magician(){

    }

    public ArrayList<String> getDialogues() {
        return dialogues;
    }
}
