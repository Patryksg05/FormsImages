package com.example.imagefirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button previousBtn, nextBtn;
    private EditText imageNameEditText, imageDescEditText;
    private ImageView galleryImageView;

    private ArrayList<Image> images = new ArrayList<Image>();
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.images = Image.images;

        previousBtn = (Button) findViewById(R.id.previousImageBtn);
        nextBtn = (Button) findViewById(R.id.nextImageBtn);
        imageNameEditText = (EditText) findViewById(R.id.imageNameEditText);
        imageDescEditText = (EditText) findViewById(R.id.imageDescEditText);
        galleryImageView = (ImageView) findViewById(R.id.galleryImageView);

        galleryImageView.setVisibility(View.VISIBLE);
        galleryImageView.setImageResource(images.get(0).getSrc());

        previousBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentIndex--;

                        if(currentIndex < 0)
                            currentIndex = images.size()-1;

                        galleryImageView.setImageResource(images.get(currentIndex).getSrc());
                    }
                }
        );

        nextBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentIndex++;

                        if(currentIndex == images.size())
                            currentIndex = 0;

                        galleryImageView.setImageResource(images.get(currentIndex).getSrc());
                    }
                }
        );
    }
}