package week08d04;

public class Trainer {
    CanMark mark;

    public Trainer(CanMark mark) {
        this.mark = mark;
    }

    public int giveMark(){
        return mark.giveMark();
    }
}
