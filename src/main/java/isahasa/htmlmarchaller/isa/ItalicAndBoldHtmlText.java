package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class ItalicAndBoldHtmlText extends HtmlText {

    public ItalicAndBoldHtmlText(String text){
        super(text);
    }

    public String getPlainText(){
        return "<i><u>" + super.getPlainText() + "</u></i>";
    }
}
