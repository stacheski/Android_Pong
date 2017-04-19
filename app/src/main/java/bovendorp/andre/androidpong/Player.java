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
    public Player(int posx, int posy){
        x = posx;
        y = posy;
        height = 100;
        width = 30;
        color = Color.argb(alpha,0,0,0);
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
}
