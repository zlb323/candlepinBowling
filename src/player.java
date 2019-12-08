import java.util.ArrayList;
import java.util.Iterator;

public class player {
    private String name;
    private ArrayList<frame> frames;
    private Iterator<frame> currentFrame;
    private int totalScore;

    public player(){
        frames = new ArrayList<>();
        frames.add(new frame());
        currentFrame = frames.iterator();
    }

    public String getName(){
        return name;
    }

    public void setName(String _name){
        name = _name;
    }

    public frame getNextFrame(){
        if(currentFrame.hasNext()){
            return currentFrame.next();
        }
        return null;
    }
}
