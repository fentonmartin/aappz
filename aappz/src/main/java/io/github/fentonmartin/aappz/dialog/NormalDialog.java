package io.github.fentonmartin.aappz.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import io.github.fentonmartin.aappz.R;

@SuppressWarnings("unused")
public class NormalDialog extends DialogFragment {

    private Callback dialogCallback;

    public NormalDialog() {
    }

    public static NormalDialog create() {
        return new NormalDialog();
    }

    public static NormalDialog create(String title) {
        NormalDialog frag = new NormalDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    public static NormalDialog create(String title, String message) {
        NormalDialog frag = new NormalDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("message", message);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null)
            if (getDialog().getWindow() != null) {
                /* Set Layout */
                getDialog().getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.WRAP_CONTENT);
                /* Set Inset Drawable */
                getDialog().getWindow().setBackgroundDrawable(new InsetDrawable(new ColorDrawable(Color.TRANSPARENT), 32, 32, 32, 32));
            }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_normal, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView dialogTitle = view.findViewById(R.id.dialog_title);
        TextView dialogMessage = view.findViewById(R.id.dialog_message);
        if (getArguments() != null) {
            dialogTitle.setText(getArguments().getString("title", ""));
            dialogMessage.setText(getArguments().getString("message", ""));
            if (getArguments().getString("message", "").isEmpty())
                view.findViewById(R.id.dialog_message_layout).setVisibility(View.GONE);
        }
    }

    public void setDialogCallback(Callback callback) {
        this.dialogCallback = callback;
    }

    public interface Callback {
        void onButtonPressed();
    }
}
