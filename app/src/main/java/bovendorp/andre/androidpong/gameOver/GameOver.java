package bovendorp.andre.androidpong.gameOver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import bovendorp.andre.androidpong.R;
import bovendorp.andre.androidpong.RenderView;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decor = getWindow().getDecorView();
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(new GameOverRenderView(this));
    }
}
