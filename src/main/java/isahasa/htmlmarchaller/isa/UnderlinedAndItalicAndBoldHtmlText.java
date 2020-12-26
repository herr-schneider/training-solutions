package isahasa.htmlmarchaller.isa;

import isahasa.htmlmarchaller.HtmlText;

public class UnderlinedAndItalicAndBoldHtmlText extends HtmlText {

    public UnderlinedAndItalicAndBoldHtmlText(String text) {
        super(text);
    }

    public String getPlainText() {
        return "<b><i><u>" + super.getPlainText() + "</u></i></b>";
    }
}