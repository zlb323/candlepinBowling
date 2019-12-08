public class frame {
    private int throw1;
    private int throw2;
    private int throw3;

    public frame(){}

    public boolean isStrike(){
        return throw1 == 10;
    }

    public boolean isSpare(){
        return throw1 + throw2 == 10;
    }
}
