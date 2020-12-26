package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class StoryBook implements Printable{
    private List<ColoredPage> coloredPages = new ArrayList<>();

public void addPage(String content, String colour){
    coloredPages.add(new ColoredPage(content,colour));

}
    @Override
    public int getLength() {
        return coloredPages.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return coloredPages.get(pageNumber).getPage();
    }

    @Override
    public String getColor(int page) {
        return coloredPages.get(page).getColor();
    }
}
