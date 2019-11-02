package win.mortalliao.starter.common.util;

import org.springframework.web.util.HtmlUtils;

import java.beans.PropertyEditorSupport;

/**
 * @author mortal
 * controller中预防XSS，进行转义
 */
public class StringEscapeEditor extends PropertyEditorSupport {

    public StringEscapeEditor() {
    }

    @Override
    public String getAsText() {
        return getValue() != null ? getValue().toString() : null;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null) {
            setValue(null);
        } else {
            setValue(HtmlUtils.htmlEscape(text));
        }
    }

}
