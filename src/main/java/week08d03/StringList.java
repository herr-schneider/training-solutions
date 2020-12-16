package week08d03;

import java.util.ArrayList;
import java.util.List;

public class StringList {
    private List<String> result = new ArrayList<>();

    public List<String> stringLists(List<String> first,List<String> second){
        System.arraycopy(first,0,result,0,first.size());
        for (String str : second) {
            if (!result.contains(str)){result.add(str);}
        }
        return result;
    }

    public List<String> stringListsNoCase(List<String> first,List<String> second){
        System.arraycopy(first,0,result,0,first.size());
        for (String strSecond : second) {
            for (String strFirst: first)
            if (!strFirst.toUpperCase().equals(strSecond.toUpperCase())){result.add(strSecond);}
        }
        return result;
    }
}
