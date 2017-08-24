package com.talon.loadingview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Talon on 2017/8/24.
 */

public class LoadingDialog {

    private AlertDialog alertDialog;
    private ImageView imageView;
    private TextView textMessage;
    private boolean isCancelable = true;


    public LoadingDialog(Context context) {
        View layout = LayoutInflater.from(context).inflate(R.layout.dialog_content_view, null);
        imageView = layout.findViewById(R.id.id_loading_view_dialog);
        imageView.setImageResource(R.drawable.loading_anim);
        textMessage = layout.findViewById(R.id.id_text_loading_dialog);
        alertDialog = new AlertDialog.Builder(context)
                .setView(layout)
                .setCancelable(isCancelable)
                .create();
    }


    public void show() {
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();
        alertDialog.show();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }


    public void setCancelable(boolean cancelable) {
        this.isCancelable = cancelable;
        alertDialog.setCancelable(isCancelable);
    }


    public void setTextMessage(String message) {
        if (textMessage != null) {
            textMessage.setText(message);
        }
    }


    public void dismiss() {
        if (alertDialog != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
            animationDrawable.stop();
            alertDialog.dismiss();
        }
    }

    public boolean isShow() {
        return alertDialog != null && alertDialog.isShowing();
    }
}
