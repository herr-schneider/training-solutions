package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Printable{

    private List<String> contain = new ArrayList<>();

    public void addPage(String content){
        contain.add(content);}

    @Override
    public int getLength() {
        return contain.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return contain.get(pageNumber);
    }

    @Override
    public String getColor(int page) {
        return Printable.BLACK;
    }
}
