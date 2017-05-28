package bovendorp.andre.androidpong;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by developer on 17/04/17.
 */

public class Player extends GameObject {
    int alpha = 255;
    int color;
    int points = 0;
    int live;

    public Player(int posx, int posy, int live){
        this.live = live;
        x = posx;
        y = posy;
        height = 100;
        width = 30;
        color = Color.argb(alpha,0,0,0);
        this.id = "Player";
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        super.draw(canvas, paint);
        paint.setColor(color);
        paint.setAlpha(alpha);
        canvas.drawRect(x - width/2 ,y -height/2 ,x+width, y+height,paint);
        paint.reset();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }

    public void setPosition(int pos, int height){
        y = pos;
        if(y >= height){
            y = height ;
        }
        if(y <= 0){
            y = 0;
        }
    }
    public void addPoints(int n){
        points += n;
    }
    public void addLive(int n){
        live += n;
        if(live < 1){
            // termina o jogo;
        }
    }

    public void setPoints(int n){
        points = n;
    }
}
