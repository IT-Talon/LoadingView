package com.talon.loadingview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private LoadingDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new LoadingDialog(this);
        dialog.setCancelable(false);
    }

    public void onClick(View view) {
        if (dialog.isShow()) {
            dialog.dismiss();
        } else {
            dialog.show();
        }
    }
}
