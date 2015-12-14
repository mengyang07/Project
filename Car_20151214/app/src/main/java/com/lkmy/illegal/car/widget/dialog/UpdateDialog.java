package com.lkmy.illegal.car.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * 作者:李凯
 * 创建时间:2015/11/27 1:23
 * 描述:
 */
public class UpdateDialog implements DialogInterface.OnClickListener {

    private Context context;
    private AlertDialog.Builder builder;
    private DialogCallback dialogCallback;


    public interface DialogCallback {
        public void callback();
    }

    public UpdateDialog(Context context) {
        this.context = context;
        builder = new AlertDialog.Builder(context);

    }

    public UpdateDialog setDialogText(String title, String message) {
        builder.setTitle(title).setMessage(message);
        return this;
    }

    public UpdateDialog setButtonText(String nButtonText, String pButtonText) {
        builder.setNegativeButton(nButtonText, this).setPositiveButton(pButtonText, this);
        return this;
    }

    public void show() {
        builder.create().show();
    }

    public UpdateDialog setDialogCallback(DialogCallback dialogCallback) {
        this.dialogCallback = dialogCallback;
        return this;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_NEGATIVE:
                dialogCallback.callback();
                break;
            case DialogInterface.BUTTON_POSITIVE:
                dialog.dismiss();
                break;
        }
    }
}
