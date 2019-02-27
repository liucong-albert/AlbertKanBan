package com.albert.albertkanbantest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by liuc on 2019-02-21.
 * 主要内容：
 */

public class SettingActivity extends Activity {
    private EditText edit_content,edit_content2,edit_content3;
    private RadioButton rdbtn_txtsize_20,rdbtn_txtsize_30,rdbtn_txtsize_40,rdbtn_txtsize_50,rdbtn_txtsize_60;
    private RadioButton rdbtn_txtsize_70,rdbtn_txtsize_80,rdbtn_txtsize_90,rdbtn_txtsize_100;
    private RadioButton rdbtn_txtstyle_marquee,rdbtn_txtstyle_normal;
    private RadioButton rdbtn_txtcolor_red,rdbtn_txtcolor_blue,rdbtn_txtcolor_black;
    private Button btn_save,btn_close;
    private TextView tv_xiaoguo;
    private RadioGroup rdggroup_txtstyle,rdggroup_txtsize,rdggroup_txtcolor;
    private int textSize = 0;
    private int style = 0;
    private int textcolor = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_setting);
        init();
        DataBean myData = new SaveData().getVenderInfo(this);
        textSize = myData.getText_size();
        style = myData.getStyle();
        textcolor = myData.getTextcolor();

        edit_content.setText(myData.getText());
        edit_content2.setText(myData.getText2());
        edit_content3.setText(myData.getText3());
        switch (textSize){
            case 20:
                rdbtn_txtsize_20.setChecked(true);
                break;
            case 30:
                rdbtn_txtsize_30.setChecked(true);
                break;
            case 40:
                rdbtn_txtsize_40.setChecked(true);
                break;
            case 50:
                rdbtn_txtsize_50.setChecked(true);
                break;
            case 60:
                rdbtn_txtsize_60.setChecked(true);
                break;
            case 70:
                rdbtn_txtsize_70.setChecked(true);
                break;
            case 80:
                rdbtn_txtsize_80.setChecked(true);
                break;
            case 90:
                rdbtn_txtsize_90.setChecked(true);
                break;
            case 100:
                rdbtn_txtsize_100.setChecked(true);
                break;
        }

        switch (style){
            case 0:
                rdbtn_txtstyle_normal.setChecked(true);
                break;
            case 1:
                rdbtn_txtstyle_marquee.setChecked(true);
                break;
        }

        switch (textcolor){
            case 0:
                rdbtn_txtcolor_red.setChecked(true);
                break;
            case 1:
                rdbtn_txtcolor_blue.setChecked(true);
                break;
            case 2:
                rdbtn_txtcolor_black.setChecked(true);
                break;
        }

    }
    private void init(){
        edit_content = findViewById(R.id.edit_content);
        edit_content2 = findViewById(R.id.edit_content2);
        edit_content3 = findViewById(R.id.edit_content3);
        rdbtn_txtsize_20 = findViewById(R.id.rdbtn_txtsize_20);
        rdbtn_txtsize_30 = findViewById(R.id.rdbtn_txtsize_30);
        rdbtn_txtsize_40 = findViewById(R.id.rdbtn_txtsize_40);
        rdbtn_txtsize_50 = findViewById(R.id.rdbtn_txtsize_50);
        rdbtn_txtsize_60 = findViewById(R.id.rdbtn_txtsize_60);
        rdbtn_txtsize_70 = findViewById(R.id.rdbtn_txtsize_70);
        rdbtn_txtsize_80 = findViewById(R.id.rdbtn_txtsize_80);
        rdbtn_txtsize_90 = findViewById(R.id.rdbtn_txtsize_90);
        rdbtn_txtsize_100 = findViewById(R.id.rdbtn_txtsize_100);
        rdbtn_txtstyle_marquee = findViewById(R.id.rdbtn_txtstyle_marquee);
        rdbtn_txtstyle_normal = findViewById(R.id.rdbtn_txtstyle_normal);
        rdbtn_txtcolor_blue = findViewById(R.id.rdbtn_txtcolor_blue);
        rdbtn_txtcolor_red = findViewById(R.id.rdbtn_txtcolor_red);
        rdbtn_txtcolor_black = findViewById(R.id.rdbtn_txtcolor_black);
        rdggroup_txtcolor = findViewById(R.id.rdggroup_txtcolor);
        btn_save = findViewById(R.id.btn_save);
        btn_close = findViewById(R.id.btn_close);
        tv_xiaoguo = findViewById(R.id.tv_xiaoguo);
        rdggroup_txtstyle = findViewById(R.id.rdggroup_txtstyle);
        rdggroup_txtsize = findViewById(R.id.rdggroup_txtsize);
        rdggroup_txtsize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rdbtn_txtsize_20:
                        textSize = 20;
                        break;
                    case R.id.rdbtn_txtsize_30:
                        textSize = 30;
                        break;
                    case R.id.rdbtn_txtsize_40:
                        textSize = 40;
                        break;
                    case R.id.rdbtn_txtsize_50:
                        textSize = 50;
                        break;
                    case R.id.rdbtn_txtsize_60:
                        textSize = 60;
                        break;
                    case R.id.rdbtn_txtsize_70:
                        textSize = 70;
                        break;
                    case R.id.rdbtn_txtsize_80:
                        textSize = 80;
                        break;
                    case R.id.rdbtn_txtsize_90:
                        textSize = 90;
                        break;
                    case R.id.rdbtn_txtsize_100:
                        textSize = 100;
                        break;
                }
                tv_xiaoguo.setText(edit_content.getText().toString().trim());
                tv_xiaoguo.setTextSize(textSize);
            }
        });
        rdggroup_txtstyle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rdbtn_txtstyle_marquee:
                        tv_xiaoguo.setText(edit_content.getText().toString().trim());
                        tv_xiaoguo.setFocusable(true);
                        tv_xiaoguo.setFocusableInTouchMode(true);
                        tv_xiaoguo.requestFocus();
                        tv_xiaoguo.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                        style = 1;
                        break;
                    case R.id.rdbtn_txtstyle_normal:
                        tv_xiaoguo.setText(edit_content.getText().toString().trim());
                        tv_xiaoguo.setEllipsize(null);
                        style = 0;
                        break;
                }
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBean bean = new DataBean();
                bean.setText_size(textSize);
                bean.setText(edit_content.getText().toString().trim());
                bean.setText2(edit_content2.getText().toString().trim());
                bean.setText3(edit_content3.getText().toString().trim());
                bean.setStyle(style);
                bean.setTextcolor(textcolor);
                new SaveData().saveConfig(SettingActivity.this,bean);
                finish();
            }
        });
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rdggroup_txtcolor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rdbtn_txtcolor_red:
                        textcolor = 1;
                        break;
                    case R.id.rdbtn_txtcolor_blue:
                        textcolor = 2;
                        break;
                    case R.id.rdbtn_txtcolor_black:
                        textcolor = 0;
                        break;
                }

            }
        });
    }
}
