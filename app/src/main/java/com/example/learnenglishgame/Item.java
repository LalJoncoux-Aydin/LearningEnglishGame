package com.example.learnenglishgame;

import java.util.ArrayList;
import java.util.Random;

public class Item {
    private String name = "";
    private final int drawable;
    public ArrayList<String> list_option = new ArrayList<String>();

    private boolean isInOptionList(String new_name) {
        for (String id : list_option) {
            if (id.equals(new_name)) {
                return true;
            }
        }
        return false;
    }

    private void findOptionalAnswers(String[] names) {
        int max_list = 4;

        for (int i = 0; i < max_list; i++) {
            Random r = new Random();
            int random = r.nextInt(25);
            String new_name = names[random];

            if (new_name.equals(name) || isInOptionList(new_name)) {
                max_list += 1;
            } else {
                list_option.add(new_name);
            }
        }
    }

    private void addCorrectAnswer() {
        Random r = new Random();
        int random_index = r.nextInt(4);
        list_option.set(random_index, name);
    }

    public Item(String name_image, int drawable_image, String[] names) {
        name = name_image;
        drawable = drawable_image;

        // Find optional answers
        findOptionalAnswers(names);

        // Add correct answer
        addCorrectAnswer();
    }

    public int getDrawable() {
        return drawable;
    }

    public String getName() {
        return name;
    }
}
