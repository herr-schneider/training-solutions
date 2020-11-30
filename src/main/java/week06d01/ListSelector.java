package week06d01;


import java.util.ArrayList;
import java.util.List;

public class ListSelector {
List<String> list = new ArrayList<>();

    /*public ListSelector(List<String> list) {
        this.list = list;
    }*/

    public void addToList(String str) {
        list.add(str);
    }

    public String selector() {
    if (list.size()<=1) {return "";}
    StringBuilder result = new StringBuilder("[");
    for (int i = 0; i < list.size(); i++) {
        if (i > 0 && i%2==0) {
            result.append(list.get(i)+ " ");
        }
    }
    result.replace(result.length()-1,result.length(),"]");
    return result.toString();
    }

    public void create(String... elementsOfList) {
        if (elementsOfList == null) { // || elementsOfList.length <1
            throw new IllegalArgumentException("There is no element!");
        }
        for (int i =0 ; i < elementsOfList.length ; i++){
            list.add(elementsOfList[i]);
        }
    }

    public String convert(String str) {
        return str.replace(" ", ", ");
    }
}