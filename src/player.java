import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class player {
    private String name;
    private List<frame> frames;
    private Iterator<frame> currentFrame;

    public player(){
        //generate 10 empty frame objects
        frames = Stream.generate(frame::new)
                .limit(10)
                .collect(Collectors.toList());
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

    public String getScoreString(){
        String str = "";
        int score = 0;
        str += "| " + name + " | ";
        for(int i = 0; i < frames.size(); i++){
            score += frames.get(i).getScore();
            str += score + " | ";
        }
        return str;
    }
}
