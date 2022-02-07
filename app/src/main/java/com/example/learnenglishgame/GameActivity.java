package com.example.learnenglishgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private ImageView img;
    private TextView display_answer;
    private ListView list;
    private int index = 0;

    private final ArrayList<Item> list_item = new ArrayList<>();
    private final String[] names = {"bulb", "backbag", "balloon", "basin", "bin", "bus", "gift", "notebook", "carot", "vaccum", "mushrooms", "cisors", "cutlery", "pencil", "sponge", "square tool", "iron", "eraser", "guitare", "wool", "eggs", "oignon", "spray", "phone", "pear", "robot"};
    private final int[] loc = {R.drawable.bulb, R.drawable.backbbag, R.drawable.balloon, R.drawable.basin, R.drawable.bin, R.drawable.bus, R.drawable.gift, R.drawable.notebook, R.drawable.carot, R.drawable.vaccum, R.drawable.mushrooms, R.drawable.cisors, R.drawable.cutlery, R.drawable.pencil, R.drawable.sponge, R.drawable.sqauretool, R.drawable.iron, R.drawable.eraser, R.drawable.guitare, R.drawable.wool, R.drawable.eggs, R.drawable.oignon, R.drawable.spray, R.drawable.phone, R.drawable.pear, R.drawable.robot};

    private void setListItem() {
        for (int i = 0; i < 26; i++) {
            Item new_item = new Item(names[i], loc[i], names);
            list_item.add(new_item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();

        // Set list of answers
        setListItem();

        setContentView(R.layout.game_layout);
        // txt
        display_answer = findViewById(R.id.answer_question);
        // img
        img = findViewById(R.id.image_displayed);
        img.setImageResource(list_item.get(index).getDrawable());
        // txt
        list = findViewById(R.id.answer_list);
        AnswerAdapter arrayAdapter = new AnswerAdapter(this, list_item.get(index).list_option);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String answer = list_item.get(index).list_option.get(position);

                // If selected answer is correct
                if (answer.equals(list_item.get(index).getName())) {
                    if (index == 25) {
                        finish();
                        return;
                    }

                    index += 1;
                    img.setImageResource(list_item.get(index).getDrawable());
                    AnswerAdapter arrayAdapter = new AnswerAdapter(getApplicationContext(), list_item.get(index).list_option);
                    list.setAdapter(arrayAdapter);
                    display_answer.setVisibility(View.GONE);
                } else {
                    display_answer.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}