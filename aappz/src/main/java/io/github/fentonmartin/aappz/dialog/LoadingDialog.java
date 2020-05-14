package io.github.fentonmartin.aappz.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import io.github.fentonmartin.aappz.R;

@SuppressWarnings("unused")
public class LoadingDialog extends DialogFragment {

    private static final String TITLE = "Please wait..";
    private static boolean isAbort = false;
    private Callback dialogCallback;

    public LoadingDialog() {
    }

    public static LoadingDialog create() {
        return new LoadingDialog();
    }

    public static LoadingDialog create(String title) {
        LoadingDialog frag = new LoadingDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    public static LoadingDialog create(String title, boolean abort) {
        isAbort = abort;
        LoadingDialog frag = new LoadingDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null)
            if (getDialog().getWindow() != null) {
                getDialog().getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.WRAP_CONTENT);
                getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (isAbort)
            return inflater.inflate(R.layout.dialog_loading_abort, container);
        else
            return inflater.inflate(R.layout.dialog_loading_default, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView dialogTitle = view.findViewById(R.id.dialog_title);
        if (getArguments() != null) {
            dialogTitle.setText(getArguments().getString("title", TITLE));
        } else dialogTitle.setText(TITLE);
        if (isAbort) {
            Button dialogButtonAbort = view.findViewById(R.id.dialog_button_abort);
            dialogButtonAbort.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dialogCallback != null)
                        dialogCallback.onButtonPressed();
                    dismiss();
                }
            });
        }
    }

    public void setDialogCallback(Callback callback) {
        this.dialogCallback = callback;
    }

    public interface Callback {
        void onButtonPressed();
    }
}
