package com.example.class1.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;
import java.util.Date;

public class HelloTag implements Tag {
    private PageContext pageContext;
    private Tag parentTag;


    //JSP環境物件
    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }
    //有沒有上層標籤
    @Override
    public void setParent(Tag t) {
        parentTag = t;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.println("晚安");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.println("現在時間: " + new Date());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }
}
