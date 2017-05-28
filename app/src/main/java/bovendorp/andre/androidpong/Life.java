package bovendorp.andre.androidpong;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by dehzo on 28/05/2017.
 */

public class Life extends GameObject {
    float radius = 20;
    int color = Color.BLACK;
    int alpha = 150;

    public Life(int indice, float posx, float posy){
        this.id = "Life" + indice;
        this.x = posx;
        this.y = posy;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        canvas.drawCircle(x, y, radius, paint);
        paint.reset();
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }

    public void setAlpha(int n){
        this.alpha = n;
    }
    public void setColor(int n){
        this.color = n;
    }
}
