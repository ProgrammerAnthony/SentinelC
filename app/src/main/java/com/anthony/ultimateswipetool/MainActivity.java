package com.anthony.ultimateswipetool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {


    @Bind(R.id.btn_show_fragment)
    Button btnShowFragment;
    @Bind(R.id.btn_show_activity)
    Button btnShowActivity;
    @Bind(R.id.btn_show_swipe_cards)
    Button btnShowSwipeCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_show_fragment, R.id.btn_show_activity, R.id.btn_show_swipe_cards})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show_fragment:
                DemoDialogFragment fragment =new DemoDialogFragment();
                fragment.show(getSupportFragmentManager(),"DemoDialogFragment");
                break;
            case R.id.btn_show_activity:
                Intent intent1 =new Intent(this,DemoSwipeBackActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_show_swipe_cards:
                Intent intent2 =new Intent(this,DemoSwipeCardsActivity.class);
                startActivity(intent2);
                break;
        }
    }


}
