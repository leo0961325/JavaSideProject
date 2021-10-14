package com.example.class1.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;

/**
 *  Tag:
 *  <my:welcome username='John'>
 *      現在時刻 : <%=new Date()=>
 *      </my:welcome>
 *
 *   OutPut:
 *   歡迎 John 光臨
 *   現在時刻 : 2021/XX/XX
 */

public class WelcomeTag implements Tag {
    private PageContext pageContext;
    private Tag parentTag;
    private String username; //自訂屬性

    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag t) {
        parentTag = t;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.println("歡迎" + username + "的光臨");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Tag.EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }
}
