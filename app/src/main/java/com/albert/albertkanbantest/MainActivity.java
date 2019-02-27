package com.albert.albertkanbantest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.tencent.stat.StatConfig;
import com.tencent.stat.StatService;

public class MainActivity extends AppCompatActivity {
    private ImageView img_setting;
    private MarqueeTextView tv_content,tv_content2,tv_content3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatConfig.setDebugEnable(true);
        // 基础统计API
        StatService.registerActivityLifecycleCallbacks(this.getApplication());
        init();
        updata();
    }
    private void init(){
        img_setting = findViewById(R.id.img_setting);
        tv_content = findViewById(R.id.tv_content);
        tv_content2 = findViewById(R.id.tv_content2);
        tv_content3 = findViewById(R.id.tv_content3);
        img_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SettingActivity.class);
                startActivityForResult(intent,101);
            }
        });
    }

    private void updata(){
        DataBean data = new SaveData().getVenderInfo(this);
        tv_content.setText(""+data.getText());
        tv_content2.setText(""+data.getText2());
        tv_content3.setText(""+data.getText3());
        tv_content.setMarqueeRepeatLimit(-1);
        tv_content2.setMarqueeRepeatLimit(-1);
        tv_content3.setMarqueeRepeatLimit(-1);
//        tv_content.Start();
//        tv_content2.Start();
//        tv_content3.Start();
        tv_content.setTextSize(data.getText_size());
        tv_content2.setTextSize(data.getText_size());
        tv_content3.setTextSize(data.getText_size());
        int color = data.getTextcolor();
        if (color == 0){
            tv_content.setTextColor(Color.BLACK);
            tv_content2.setTextColor(Color.BLACK);
            tv_content3.setTextColor(Color.BLACK);
        }else if(color == 1){
            tv_content.setTextColor(Color.RED);
            tv_content2.setTextColor(Color.RED);
            tv_content3.setTextColor(Color.RED);
        }else if (color == 2){
            tv_content.setTextColor(Color.BLUE);
            tv_content2.setTextColor(Color.BLUE);
            tv_content3.setTextColor(Color.BLUE);
        }

        if (data.getStyle() == 1){
            tv_content.setFocusable(true);
            tv_content.setFocusableInTouchMode(true);
            tv_content.requestFocus();
            tv_content.setEllipsize(TextUtils.TruncateAt.MARQUEE);

            tv_content2.setFocusable(true);
            tv_content2.setFocusableInTouchMode(true);
            tv_content2.requestFocus();
            tv_content2.setEllipsize(TextUtils.TruncateAt.MARQUEE);

            tv_content3.setFocusable(true);
            tv_content3.setFocusableInTouchMode(true);
            tv_content3.requestFocus();
            tv_content3.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101){
            updata();
        }
    }
}
