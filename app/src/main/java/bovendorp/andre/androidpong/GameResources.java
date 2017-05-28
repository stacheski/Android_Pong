package bovendorp.andre.androidpong;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by developer on 17/04/17.
 */
public class GameResources {
    private static GameResources ourInstance = new GameResources();

    public static GameResources getInstance() {
        return ourInstance;
    }

    private GameResources() {
    }
    public List<GameObject> gameObjectsList = new ArrayList<>();
    private List<GameObject> gameObjectsList2 = new ArrayList<>();

    public void addObject(GameObject obj){
        gameObjectsList2.add(obj);
    }

    public GameObject get(String s){
        for(GameObject g: gameObjectsList){
            if(g.id.equals(s)){
                return g;
            }
        }
        return null;
    }

    public void removeObject(GameObject obj){
        gameObjectsList2.remove(obj);
    }

    public void updateAndDraw(float deltaTime, Canvas canvas, Paint paint){
        for (GameObject obj: gameObjectsList){
            obj.update(deltaTime);
            obj.draw(canvas, paint);
        }
    }

    public void swap(){
        // double buffer pra poder deletar sem problemas
        this.gameObjectsList.clear();
        for(GameObject g: gameObjectsList2){
            this.gameObjectsList.add(g);
        }
    }
}
