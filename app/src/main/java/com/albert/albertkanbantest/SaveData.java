package com.albert.albertkanbantest;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by liuc on 2019-02-21.
 * 主要内容：
 */

public class SaveData {
    public void saveConfig(Context activity, DataBean info){
        SharedPreferences sp = activity.getSharedPreferences("VenderConfig", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        //通过editor对象写入数据
        edit.putString("text",info.getText());
        edit.putString("text2",info.getText2());
        edit.putString("text3",info.getText3());
        edit.putInt("textsize",info.getText_size());
        edit.putInt("style",info.getStyle());
        edit.putInt("color",info.getTextcolor());
        //提交数据存入到xml文件中
        edit.commit();
    }

    public DataBean getVenderInfo(Context activity){
        DataBean info = new DataBean();
        SharedPreferences pref = activity.getSharedPreferences("VenderConfig",MODE_PRIVATE);
        info.setStyle(pref.getInt("style",0));
        info.setText(pref.getString("text",null));
        info.setText2(pref.getString("text2",null));
        info.setText3(pref.getString("text3",null));
        info.setText_size(pref.getInt("textsize",0));
        info.setTextcolor(pref.getInt("color",0));
        return info;
    }
}
