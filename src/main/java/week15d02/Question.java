package week15d02;

public class Question {
    private String question;
    private String answer;
    private int score;
    private String qType;

    public Question(String question, String answer, int score, String qType) {
        this.question = question;
        this.answer = answer;
        this.score = score;
        this.qType = qType;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getScore() {
        return score;
    }

    public String getqType() {
        return qType;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", score=" + score +
                ", qType='" + qType + '\'' +
                '}';
    }
}