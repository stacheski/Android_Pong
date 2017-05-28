package bovendorp.andre.androidpong;

/**
 * Created by developer on 17/04/17.
 */

public class Bot extends Player {
    GameObject reference;
    int speed;
    public Bot(int posx, int posy, GameObject reference){
        super(posx, posy, 1);
        this.reference = reference;
    }

    public void addSpeed(int n){
        speed += n;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        this.y = reference.y;
        this.id = "Bot";
    }
}
