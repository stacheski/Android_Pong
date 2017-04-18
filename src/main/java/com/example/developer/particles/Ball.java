package com.example.developer.particles;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by developer on 17/04/17.
 */

public class Ball extends GameObject {
    public static final int GOING_RIGHT = 1;
    public static final int GOING_LEFT = -1;
    public static final int GOING_DOWN = 1;
    public static final int GOING_UP = -1;

    float speed = 0.5f;

    private int directionX = 1;
    private int directionY = 1;
    int color = Color.BLACK;
    int alpha = 255;
    int radius = 10;
    int screenX, screenY;


    public Ball(int posx, int posy, int screenX, int screenY){
        this.x = posx;
        this.y = posy;
        this.screenX = screenX;
        this.screenY = screenY;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        super.draw(canvas, paint);
        paint.setColor(color);
        paint.setAlpha(alpha);
        canvas.drawCircle(x, y, radius, paint);
        paint.reset();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        // TODO: Diferenciar velocidades nos eixos X e Y

        this.y += (directionY * speed * deltaTime);
        this.x += (directionX * speed * deltaTime);
        if(y >= screenY){
            y = screenY;
            directionY = GOING_UP;
        } else if(y <= 0){
            y = 0;
            directionY = GOING_DOWN;
        }

        // TODO: Verificar colisao com o player e o bot e colocar o codigo abaixo nele.

        if(x >= screenX){
            x = screenX;
            directionX = GOING_LEFT;
        } else if(x <= 0){
            x = 0;
            directionX = GOING_RIGHT;
        }
    }

}
