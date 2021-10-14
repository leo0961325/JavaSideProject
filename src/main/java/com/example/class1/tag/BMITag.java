package com.example.class1.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import java.io.IOException;

public class BMITag implements Tag {
    private PageContext pageContext;
    private Tag parentTag;

    private Integer height;
    private Integer weight;
    private Boolean result;

    @Override
    public void setPageContext(PageContext pc) {
        pageContext=pc;
    }

    @Override
    public void setParent(Tag t) {
        parentTag = t;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    @Override
    public int doStartTag() throws JspException {
        double bmi = weight / Math.pow(height/100.0,2);
        JspWriter out = pageContext.getOut();
        try {
            out.println("身高 : " + height);
            out.println("體重 : " + weight);
            out.println("BMI指數: " + bmi);
            if(result!=null && result){
                if(bmi <= 18){
                    out.println("太瘦");
                } else if (bmi >= 23) {
                    out.println("太胖");
                }else {
                    out.println("正常");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {


        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {

    }
}
