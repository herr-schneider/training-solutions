package week08d04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrainerTest{

    @Test
    public void testGood(){
        Trainer t = new Trainer(new GoodMood());
        assertEquals(5, t.giveMark());
    }

    @Test
    public void testBad(){
        Trainer otherT = new Trainer(new BadMood());
        assertEquals(3, otherT.giveMark());
    }
}
