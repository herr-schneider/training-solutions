package isahasa.htmlmarchaller.hasa;

import isahasa.htmlmarchaller.TextSource;

public class UnderLine extends TextDecorator {

    public UnderLine(TextSource textSource) {
        super(textSource);
    }

    @Override
    public String getPlainText() {
        return "<u>" + getTextSource().getPlainText() + "</u>";
    }
}