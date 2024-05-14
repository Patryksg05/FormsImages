package com.example.imagefirstapp;

import android.widget.GridLayout;

import java.util.ArrayList;

public class Image {
    private String name;
    private String desc;
    private int src;

    public static ArrayList<Image> images = new ArrayList<Image>() {{
        add(new Image("camera1", "sth with camera", R.drawable.ic_baseline_camera_alt_24));
        add(new Image("camera2", "sth with camera", R.drawable.camera2));
        add(new Image("camera3", "sth with camera", R.drawable.camera3));
    }};

    public Image(String name, String desc, int src) {
        this.name = name;
        this.desc = desc;
        this.src = src;
    }

    public Image(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.src = R.drawable.ic_launcher_foreground;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getSrc() {
        return src;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
