package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class BoldHtmlText extends HtmlText {

    public BoldHtmlText(String boltText){
        super(boltText);
    }

    public String getPlainText(){
        return "<b>" + super.getPlainText() + "</b>";
    }
}
