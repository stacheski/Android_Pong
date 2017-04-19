package bovendorp.andre.androidpong;

import android.graphics.Canvas;
import android.graphics.Paint;


public abstract class GameObject {
    public float x=0, y=0;
    public float width=0, height=0;
    public int layer = 0;
    public String id = "";

    public void update(float deltaTime){

    }
    public void draw(Canvas canvas, Paint paint){

    }
}
