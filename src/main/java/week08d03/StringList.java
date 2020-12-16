package week08d03;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class StringList {
    private List<String> result = new ArrayList<>();

    public List<String> stringLists(List<String> first,List<String> second){
        List<String> result = new ArrayList<>(first);
        for (String strSecond : second) {
           if (!result.contains(strSecond)){result.add(strSecond);}
        }
        return result;
    }

    public List<String> stringListsNoCase(List<String> first,List<String> second){
        List<String> result = new ArrayList<>(first);
        for (String strSecond : second) {
            if (!containsIgnoreCase(first, strSecond)){result.add(strSecond);}
        }
        return result;
    }

    public boolean containsIgnoreCase(List<String> stringList, String search){
           for (String str: stringList){
                if (str.toUpperCase().equals(search.toUpperCase())){return true;}
            }
           return false;
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringList that = (StringList) o;
        return result.equals(that.result);
    }
}
