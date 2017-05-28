package bovendorp.andre.androidpong;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

import bovendorp.andre.androidpong.game.RenderView;

/**
 * Created by developer on 17/04/17.
 */

public class Ball extends GameObject {
    public static final int GOING_RIGHT = 1;
    public static final int GOING_LEFT = -1;
    public static final int GOING_DOWN = 1;
    public static final int GOING_UP = -1;

    float speedX = 0.5f;
    float speedY = 0.5f;

    private int directionX = 1;
    private int directionY = 1;
    int color = Color.BLACK;
    int alpha = 255;
    int radius = 10;
    int screenX, screenY;
    private final float MAXSPEED = 3;
    Random r;

    public Ball(int posx, int posy, int screenX, int screenY) {
        this.x = posx;
        this.y = posy;
        this.screenX = screenX;
        this.screenY = screenY;
        this.id = "Bolinha";
        r = new Random();
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

        // cria o box da tela e não deixa passar a bolinha da tela.
        this.y += (directionY * speedY * deltaTime);
        this.x += (directionX * speedX * deltaTime);
        if (y >= screenY) {
            y = screenY;
            directionY = GOING_UP;
        } else if (y <= 0) {
            y = 0;
            directionY = GOING_DOWN;
        }
        if (x >= screenX) {
            x = screenX;
            directionX = GOING_LEFT;
        } else if (x <= 0) {
            x = 0;
            directionX = GOING_RIGHT;
            // caso bata na parede atras do player
            this.removeLife();

            // reseta o jogo" para a bolinha no centro
            this.reset();

            return;

        }
        // fim dos bounds

        // verifica a colisão com os outros objetos
        for (GameObject g : GameResources.getInstance().gameObjectsList) {
            if (g.id.equals("Bolinha"))
                continue;
            if (collision(g)) {
                // toca o som
                RenderView.mp.start();

                // Muda a diração
                toggleX();

                //Adiciona a pontuação
                if (g instanceof Player && g.id.equals("Player")) {
                    ((Player) g).addPoints((int) ((100 * speedX) * .5f + ((100 * speedY) * .5f)));
                }

                // sorteia o aumento da velocidade.
                if (r.nextBoolean()) {
                    this.addSpeedX(.05f);
                } else {
                    this.addSpeedY(.03f);
                }

            }
        }
    }

    public boolean collision(GameObject target) {
        if (target.id.equals("Bot")) {
            if (this.x > target.x - target.width * .5) {
                if (this.y >= target.y - target.height * .5 && this.y <= target.y + target.height) {
                    return true;
                }
            }
        } else if (target.id.equals("Player")) {
            if (this.x < target.x + target.width * .5) {
                if (this.y >= target.y - target.height * .5 && this.y <= target.y + target.height) {
                    return true;
                }
            }
        }
        return false;
    }

    private void toggleX() {
        if (directionX == GOING_RIGHT) {
            // arruma a posicao para que nao nao ocorra erros em altas velocidadaes
            this.x -= radius * 5;
            directionX = GOING_LEFT;
        } else {
            // arruma a posicao para que nao nao ocorra erros em altas velocidadaes
            this.x += radius * 5;
            directionX = GOING_RIGHT;
        }
    }

    private void reset() {
        this.speedY = .5f;
        this.speedX = .5f;
        this.x = screenX * .5f;
        this.y = screenX * .5f;
    }

    private void addSpeedX(float n) {
        this.speedX += n;
        if (this.speedX > MAXSPEED) {
            this.speedX = MAXSPEED;
        }
    }

    private void addSpeedY(float n) {
        this.speedY += n;
        if (this.speedY > MAXSPEED) {
            this.speedY = MAXSPEED;
        }
    }

    private void removeLife(){
        Player p = (Player) GameResources.getInstance().get("Player");
        if(p.getLives() > 0){
            String obj = "Life" + (p.getLives());
            GameObject g = GameResources.getInstance().get(obj);
            GameResources.getInstance().removeObject(g);
        }
        p.addLive(-1);
    }

}
