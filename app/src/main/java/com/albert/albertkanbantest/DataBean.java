package com.albert.albertkanbantest;

import java.io.Serializable;

/**
 * Created by liuc on 2019-02-21.
 * 主要内容：
 */

public class DataBean implements Serializable{
    private int text_size; //0为20，1为30，2为40，3为50，4为60
    private String text;
    private String text2;
    private String text3;
    private int style; //0为普通样式，1为跑马灯样式
    private int textcolor; //1为红色，2为蓝色，0为默认黑色

    public int getTextcolor() {
        return textcolor;
    }

    public void setTextcolor(int textcolor) {
        this.textcolor = textcolor;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public int getText_size() {
        return text_size;
    }

    public void setText_size(int text_size) {
        this.text_size = text_size;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }
}
