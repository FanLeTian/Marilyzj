package com.abc.marilyzj.widgets;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abc.marilyzj.R;




public class LoadingDialog extends DialogFragmentImpl {

    private TextView tvMessage;
    private String message;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setStyle(DialogFragment.STYLE_NO_TITLE, getTheme());
        View view = getActivity().getLayoutInflater().inflate(R.layout.loading_dialog, container, false);
        tvMessage = (TextView) view.findViewById(R.id.tv_message);
        tvMessage.setText(message);
        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Theme_AppCompat);
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    return true;
                }
                return false;
            }
        });
        return dialog;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public static class Builder {
        LoadingDialog loadingDialog;

        public Builder() {
            loadingDialog = new LoadingDialog();
        }

        public Builder setMessage(String message) {
            loadingDialog.setMessage(message);
            return this;
        }

        public LoadingDialog create() {
            return loadingDialog;
        }

    }
}
