package bovendorp.andre.androidpong.gameOver;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import bovendorp.andre.androidpong.Player;

public class GameOverRenderView extends View {
    Paint paint;

    public GameOverRenderView(Context context) {
        super(context);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRGB(0, 0, 0);
        paint.setTextSize(150);
        paint.setColor(Color.WHITE);
        canvas.drawText("GAME OVER!", (getWidth() / 6), getHeight() / 2, paint);
        paint.setTextSize(40);
        canvas.drawText("Points: " + Player.spoints, getWidth()/2 - 120, getHeight()/3 * 2, paint);
        invalidate();
    }
}
