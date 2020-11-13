package week3;


import  org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationTest {

    @Test
    public void TestCreate(){

    Operation op = new Operation("123+45");

    int result = op.getResult();

       assertEquals(168, result);
    }
}
