package bovendorp.andre.androidpong.Menu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by dehzo on 28/05/2017.
 */

public class MenuRenderView extends View {
    Paint paint = new Paint();
    public MenuRenderView(Context context) {
        super(context);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRGB(200,200,200);
        paint.setTextSize(30);
        paint.setColor(Color.BLACK);
        canvas.drawText("Menu", 0,0, paint);
        paint.setTextSize(100);
        canvas.drawText("START", (getWidth() * 3) /2, getHeight()/2, paint);
        invalidate();
    }
}
