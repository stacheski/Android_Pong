package bovendorp.andre.androidpong.gameOver;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by dehzo on 28/05/2017.
 */

public class GameOverRenderView extends View {
    Paint paint;
    float startTime;

    public GameOverRenderView(Context context) {
        super(context);
        paint = new Paint();
        startTime = System.nanoTime();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float deltaTime = (System.nanoTime() - startTime) / 1000000.0f;
        startTime = System.nanoTime();

        canvas.drawRGB(200, 200, 200);
        paint.setTextSize(100);
        canvas.drawText("GAME OVER!", (getWidth() / 3) * 2, getHeight() / 2, paint);
        invalidate();

    }
}
