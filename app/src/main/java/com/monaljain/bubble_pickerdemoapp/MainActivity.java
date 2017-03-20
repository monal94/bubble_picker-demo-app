package com.monaljain.bubble_pickerdemoapp;

import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.widget.Toast;

import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BubblePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        picker = (BubblePicker) findViewById(R.id.picker);

        final String[] titles = getResources().getStringArray(R.array.countries);
        final TypedArray colors = getResources().obtainTypedArray(R.array.colors);
        final TypedArray images = getResources().obtainTypedArray(R.array.images);

        picker.setItems(new ArrayList<PickerItem>() {
            {
                for (int i = 0; i < titles.length; ++i) {
                    add(new PickerItem(titles[i], colors.getColor((i * 2) % 8, 0),
                            ContextCompat.getColor(MainActivity.this, android.R.color.white),
                            ContextCompat.getDrawable(MainActivity.this, images.getResourceId(i, 0))));
                }
            }
        });

        picker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(PickerItem item) {
//                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_LONG);
            }

            @Override
            public void onBubbleDeselected(PickerItem item) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        picker.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        picker.onPause();
    }
}
