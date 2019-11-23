package com.example.videogameships.Model;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.videogameships.R;

import java.util.Random;

public class Rock {

    public static final float INIT_X =2000;
    public static final float INIT_Y =10;
    public static  int SPRITE_SIZE_WIDTH =150;
    public static  int SPRITE_SIZE_HEIGTH=250;
    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;
    private float maxY;
    private float maxX;
    private float speed;
    private float positionX;
    private float positionY;
    private Bitmap spriteRock;
    private boolean delete;


    public Rock (Context context, float screenWidth, float screenHeigth){
        delete = false;
        Random randomGenerator = new Random();
        speed = randomGenerator.nextInt(8);
        positionX = this.INIT_X;
        positionY = randomGenerator.nextInt(500);
        //Getting bitmap from resource
        Bitmap originalBitmap= BitmapFactory.decodeResource(context.getResources(), R.drawable.rock);
        spriteRock  = Bitmap.createScaledBitmap(originalBitmap, SPRITE_SIZE_WIDTH, SPRITE_SIZE_HEIGTH, false);

        this.maxX = screenWidth - (spriteRock.getWidth()/2);
        this.maxY = screenHeigth - spriteRock.getHeight();
    }


    public static float getInitX() {
        return INIT_X;
    }

    public static float getInitY() {
        return INIT_Y;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public Bitmap getSpriteRock() {
        return spriteRock;
    }

    public void setSpriteRock(Bitmap spriteCloud) {
        this.spriteRock = spriteCloud;
    }

    public boolean getBorrar(){
        return this.delete;
    }

    public void updateInfo () {


        this.positionX -=speed;
        System.out.println(this.getPositionX());
        if(this.positionX <= 0) {
            this.delete = true;
        }
    }
}