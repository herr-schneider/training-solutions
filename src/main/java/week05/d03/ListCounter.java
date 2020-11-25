package week05.d03;

import org.junit.Test;
import schoolrecords.ClassRecords;
import schoolrecords.Student;
import week05d02.ChangeLetter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ListCounter {
    private final char c = 'a';


    public int counter(List<String> inputList, char c, boolean throwException) {
        int outPutInt = 0;
        if (inputList.size() < 1 && throwException) {throw new ArrayStoreException("Empty List!");};
        for (String underExamination : inputList) {
            if (underExamination.charAt(0) == c || underExamination.toLowerCase().charAt(0) == c) {
                outPutInt++;
            }
        }
        return outPutInt;
    }


    @Test
    public void testsitution(){
        List<String> testList = Arrays.asList("Alma", "Korte", "avocado", "kukorica", "abanán");
        assertEquals(3, counter(testList, c, false));
    }

    @Test
    public void testsitutionNullList(){
        List<String> testList = new ArrayList<>();
        assertEquals(0, counter(testList, c, false));
    }

    @Test
    public void emptyListShouldThrowException() throws ArrayStoreException {
        List<String> testList = new ArrayList<>();

        Exception ex = assertThrows(ArrayStoreException.class, () -> counter(testList, c, true));
        assertEquals("Empty List!", ex.getMessage());
    }
}
