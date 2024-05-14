package com.example.imagefirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class RandomImage extends AppCompatActivity {

    private ImageView imageView;
    private Button randomImageBtn;
    private TextView imageNameTextView, imageDescTextView;
    private final Random random = new Random();

    private ArrayList<Image> images = new ArrayList<Image>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_image);

        images = Image.images;

        imageView = (ImageView) findViewById(R.id.randomImageView);
        randomImageBtn = (Button) findViewById(R.id.randomImageBtn);
        imageNameTextView = (TextView) findViewById(R.id.imageNameTextView);
        imageDescTextView = (TextView) findViewById(R.id.imageDescTextView);

        randomImageBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int randomIndex = random.nextInt(images.size());
                        imageView.setImageResource(images.get(randomIndex).getSrc());
                        imageNameTextView.setText(images.get(randomIndex).getName());
                        imageDescTextView.setText(images.get(randomIndex).getDesc());
                    }
                }
        );
    }
}