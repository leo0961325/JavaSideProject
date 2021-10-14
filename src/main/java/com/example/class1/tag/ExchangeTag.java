package com.example.class1.tag;


import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 * <my:exchange symbol='USDTWD =x'></my:exchange>
 * <p>
 * 美金兌換台幣
 * 1USD 兌 29.8 TWD
 * <my:exchange symbol='USDTWD =x' reverse =  'true'></my:exchange>
 * <p>
 * 1TWD 兌 0.034 USD
 */

public class ExchangeTag implements Tag {
    private PageContext pageContext;
    private Tag parentTag;
    private String symbol;

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

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            if (symbol != null && symbol.length() == 8) {
                Stock stock = YahooFinance.get(symbol);

                double price = stock.getQuote().getPrice().doubleValue();

                out.println("1");
                out.println(symbol.substring(0, 3) + "");
                out.println(price + "");
                out.println(symbol.substring(3, 6) + "<p/>");
            }else {
                out.println("symbol 格式錯誤 : " + symbol);
            }

        } catch (Exception e) {

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
