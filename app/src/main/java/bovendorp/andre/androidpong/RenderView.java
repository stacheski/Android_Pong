package bovendorp.andre.androidpong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class RenderView extends View {
    Paint paint = new Paint();
    Player player1 = null;
    Bot player2 = null;
    Ball bolinha = null;

    float startTime;

    public RenderView(Context context){
        super(context);
        startTime = System.nanoTime();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if(player1 == null){
            player1 = new Player(100,getHeight()/2, 3);
            GameResources.getInstance().addObject(player1);
        }
        if(bolinha == null){
            bolinha = new Ball(getWidth()/2, getHeight()/2, getWidth(), getHeight());
            GameResources.getInstance().addObject(bolinha);
        }
        if(player2 == null){
            player2 = new Bot(getWidth() -100, getHeight()/2, bolinha);
            GameResources.getInstance().addObject(player2);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float deltaTime = (System.nanoTime() - startTime) / 1000000.0f;
        startTime = System.nanoTime();

        canvas.drawRGB(200,200,200);
        GameResources.getInstance().updateAndDraw(deltaTime, canvas, paint);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            player1.setPosition((int) event.getY(),getHeight());
        }
        return true;
    }
}
