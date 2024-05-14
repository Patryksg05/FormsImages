package com.example.imagefirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button previousBtn, nextBtn, addBtn, nextActivityBtn;
    private EditText imageNameEditText, imageDescEditText;
    private ImageView galleryImageView;
    private Spinner spinner;

    private GridLayout galleryGridLayout;

    private ArrayList<Image> images = new ArrayList<Image>();
    private ArrayList<Image> views = new ArrayList<Image>();
//    private ImageView[] views = new ImageView[10];
    private final Random random = new Random();

    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.images = Image.images;
        this.views = Image.images;

        previousBtn = (Button) findViewById(R.id.previousImageBtn);
        nextBtn = (Button) findViewById(R.id.nextImageBtn);
        addBtn = (Button) findViewById(R.id.newImageBtn);
        nextActivityBtn = (Button) findViewById(R.id.nextActivityBtn);
        imageNameEditText = (EditText) findViewById(R.id.imageNameEditText);
        imageDescEditText = (EditText) findViewById(R.id.imageDescEditText);
        galleryImageView = (ImageView) findViewById(R.id.galleryImageView);
        galleryGridLayout = (GridLayout) findViewById(R.id.centerGridLayout);
        spinner = (Spinner) findViewById(R.id.spinner);

        galleryImageView.setVisibility(View.VISIBLE);
        galleryImageView.setImageResource(images.get(0).getSrc());

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter spinnerAdapter = new ArrayAdapter(
                this, android.R.layout.simple_spinner_dropdown_item,images
        );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        addBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!imageNameEditText.getText().toString().equals("")
                            && !imageDescEditText.getText().toString().equals(""))
                        {
                            Image image = new Image(
                                    imageNameEditText.getText().toString(),
                                    imageDescEditText.getText().toString(),
                                    R.drawable.camera4);
                            images.add(image);
                        }
                        else
                            Toast.makeText(MainActivity.this, "Fill inputs!", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        setGridLayout();
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//        params.weight = 1;

//        for(int i=0; i<10; i++)
//        {
//            ImageView image = new ImageView(this);
////            image.setLayoutParams(new android.view.ViewGroup.LayoutParams(200,200));
////            image.setMaxHeight(20);
////            image.setMaxWidth(20);
//            image.setLayoutParams(new GridLayout.LayoutParams());
//            image.setImageResource(R.drawable.camera2);
//            galleryGridLayout.addView(image);
//        }

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

        nextActivityBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, RandomImage.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void setGridLayout()
    {
        for(int i=0; i<views.size(); i++)
        {
            ImageView image = new ImageView(this);
            image.setLayoutParams(new GridLayout.LayoutParams());
            image.setImageResource(images.get(i).getSrc());
            galleryGridLayout.addView(image);

            final int position = i;

            image.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this,
                                    "Name: " + images.get(position).getName() +
                                            "\nDesc: " + images.get(position).getDesc(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
            );
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        galleryImageView.setImageResource(images.get(position).getSrc());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}