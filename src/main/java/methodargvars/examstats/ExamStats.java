package methodargvars.examstats;

public class ExamStats {
    private final int maxPoints;

    public ExamStats(int maxPoints){
    this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results){
        try {if (results.length < 1) {
            throw new IllegalArgumentException ("Number of results must not be empty!");
        }
        } catch (NullPointerException npe) {throw new IllegalArgumentException("Number of results must not be empty!");}
        int numOfUpper = 0;

        int limit = maxPoints*limitInPercent/100;
        if (limit>maxPoints) {throw new IllegalArgumentException ("Limit is too high!");}
        for (int i =0 ; i < results.length ; i++){
            if (results[i] > limit) {
                numOfUpper++;
            }
        }

        return numOfUpper;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results){
        if (results.length < 1) {
            throw new IllegalArgumentException ("Number of results must not be empty!");
        }
        int numOfUpper = 0;
        int limit = maxPoints*limitInPercent/100;
        if (limit>maxPoints) {throw new IllegalArgumentException ("Limit is too high!");}
        try {
            for (int i = 0; i < results.length; i++) {
                if (results[i] < limit) {
                    return true;
                }
            }
        } catch (NullPointerException npe) {throw new IllegalArgumentException("");}
        return false;
    }

}
