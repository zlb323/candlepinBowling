public class frame {
    private int[] throwresults;
    private int currentThrow;
    private int totalScore;

    public frame(){
        throwresults = new int[3];
        currentThrow = 0;
        totalScore = 0;
    }

    public boolean isStrike(){
        return throwresults[0] == 10;
    }

    public boolean isSpare(){
        return throwresults[0] + throwresults[1] == 10;
    }

    public boolean throwResult(int pins){
        if(totalScore + pins > 10) {
            System.out.println("Total Score for a frame cannont exceed 10, Please reenter score:");
            return false;
        }
        throwresults[currentThrow] = pins;
        totalScore += pins;
        if(currentThrow == 2 || totalScore == 10) return true;
        currentThrow++;
        return false;
    }
}
