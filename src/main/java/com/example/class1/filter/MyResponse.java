package com.example.class1.filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyResponse extends HttpServletResponseWrapper {

    private PrintWriter out;
    //像是一個集合 char array
    private CharArrayWriter bufferedWriter;

    public MyResponse(HttpServletResponse response) {
        super(response);

        bufferedWriter = new CharArrayWriter();
        //bufferedWriter 放進去 out(容器)裡面
        out = new PrintWriter(bufferedWriter);
    }
    //取代原生的getWriter 返回自定義的out
    @Override
    public PrintWriter getWriter() throws IOException {
        return out;
    }
    public String getHTMLString(){
        return bufferedWriter.toString();
    }

}
