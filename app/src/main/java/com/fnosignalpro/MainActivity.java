package com.fnosignalpro;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {
    LinearLayout root, content;
    int white=Color.rgb(240,244,255), bg=Color.rgb(11,16,32), card=Color.rgb(21,28,48);

    TextView tv(String s,int sp,boolean bold){
        TextView v=new TextView(this);
        v.setText(s); v.setTextColor(white); v.setTextSize(sp);
        v.setTypeface(Typeface.DEFAULT,bold?Typeface.BOLD:Typeface.NORMAL);
        v.setPadding(16,12,16,12); return v;
    }
    void signal(String title,String body,String risk){
        LinearLayout box=new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL); box.setPadding(8,4,8,4);
        GradientDrawable g=new GradientDrawable(); g.setColor(card); g.setCornerRadius(24); box.setBackground(g);
        box.addView(tv(title,18,true)); box.addView(tv(body,14,false)); box.addView(tv("Risk: "+risk,13,true));
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(-1,-2);
        lp.setMargins(0,0,0,14); content.addView(box,lp);
    }
    void show(String tab){
        content.removeAllViews();
        if(tab.equals("Home")){
            content.addView(tv("MARKET LIVE  •  INDIAN F&O",13,true));
            content.addView(tv("NIFTY 50   24,975.40   +0.55%",19,true));
            content.addView(tv("BANK NIFTY   52,262.30   +0.73%",19,true));
            content.addView(tv("Latest Signals",24,true));
            signal("BUY  NIFTY 25,000 CE","Entry ₹125–130  •  T1 ₹145  •  T2 ₹160  •  SL ₹110","MEDIUM");
            signal("BUY  BANK NIFTY 51,500 PE","Entry ₹145–150  •  T1 ₹175  •  T2 ₹195  •  SL ₹125","LOW");
            signal("BUY  NIFTY 24,900 CE","Entry ₹110–115  •  T1 ₹145  •  T2 ₹165  •  SL ₹90","HIGH");
            content.addView(tv("Demo data only. No trade execution.",12,false));
        } else if(tab.equals("Market")){
            content.addView(tv("Market",26,true));
            content.addView(tv("NIFTY 50\n24,975.40   +0.55%\n\nBANK NIFTY\n52,262.30   +0.73%\n\nFINNIFTY\n22,562.30   -0.20%\n\nINDIA VIX\n14.82   +1.42%",18,false));
        } else if(tab.equals("Alerts")){
            content.addView(tv("Notifications",26,true));
            content.addView(tv("09:42  BUY NIFTY 25,000 CE\nEntry ₹125–130 • Risk MEDIUM\n\n09:18  BUY BANK NIFTY 51,500 PE\nEntry ₹145–150 • Risk LOW",17,false));
        } else {
            content.addView(tv("Profile",26,true));
            content.addView(tv("Mobile login\nOne active device\n\nSubscription\n₹99 / 5 notifications per day\n₹299 / 20 notifications per day\n₹399 / Unlimited notifications\n\nRisk preference\nLOW • MEDIUM • HIGH",17,false));
        }
    }
    @Override public void onCreate(Bundle b){
        super.onCreate(b);
        root=new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL); root.setBackgroundColor(bg);
        LinearLayout bar=new LinearLayout(this); bar.setGravity(Gravity.CENTER_VERTICAL);
        bar.addView(tv("F&O Signal Pro",25,true),new LinearLayout.LayoutParams(0,70,1));
        Button bell=new Button(this); bell.setText("🔔"); bar.addView(bell,new LinearLayout.LayoutParams(70,70));
        root.addView(bar);
        ScrollView scroll=new ScrollView(this);
        content=new LinearLayout(this); content.setOrientation(LinearLayout.VERTICAL); content.setPadding(18,10,18,20);
        scroll.addView(content); root.addView(scroll,new LinearLayout.LayoutParams(-1,0,1));
        LinearLayout nav=new LinearLayout(this);
        for(String t:new String[]{"Home","Market","Alerts","Profile"}){
            Button x=new Button(this); x.setText(t); x.setOnClickListener(v->show(t));
            nav.addView(x,new LinearLayout.LayoutParams(0,64,1));
        }
        root.addView(nav); setContentView(root); show("Home");
    }
}
