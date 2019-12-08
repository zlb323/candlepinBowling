public class player {
    private String name;
    private frame[] frames;
    private frame currentFrame;
    private int totalScore;

    public player(){
        frames = new frame[10];
    }

    public String getName(){
        return name;
    }

    public void setName(String _name){
        name = _name;
    }
}
