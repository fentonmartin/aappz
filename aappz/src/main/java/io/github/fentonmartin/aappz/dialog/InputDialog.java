package io.github.fentonmartin.aappz.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import io.github.fentonmartin.aappz.R;

@SuppressWarnings("unused")
public class InputDialog extends DialogFragment {

    private Callback dialogCallback;
    private CallbackTwo dialogCallbackTwo;

    public InputDialog() {
    }

    public static InputDialog create() {
        return new InputDialog();
    }

    public static InputDialog create(String title, String message, String text, String button1, String button2) {
        InputDialog frag = new InputDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("message", message);
        args.putString("text", text);
        args.putString("button1", button1);
        args.putString("button2", button2);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null)
            if (getDialog().getWindow() != null) {
                /* Set Layout */
                getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.WRAP_CONTENT);
                /* Set Inset Drawable */
                getDialog().getWindow().setBackgroundDrawable(new InsetDrawable(new ColorDrawable(Color.TRANSPARENT), 32, 32, 32, 32));
            }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_input, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView dialogTitle = view.findViewById(R.id.dialog_title);
        TextView dialogMessage = view.findViewById(R.id.dialog_message);
        final EditText dialogEdit = view.findViewById(R.id.dialog_edit);
        Button dialogButton1 = view.findViewById(R.id.dialog_button_1);
        Button dialogButton2 = view.findViewById(R.id.dialog_button_2);

        if (getArguments() != null) {
            dialogTitle.setText(getArguments().getString("title", ""));
            dialogMessage.setText(getArguments().getString("message", ""));
            dialogEdit.setText(getArguments().getString("text", ""));
            dialogButton1.setText(getArguments().getString("button1", "Cancel"));
            dialogButton2.setText(getArguments().getString("button2", "Submit"));
            dialogEdit.setRawInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);

            /* Set layout visibility */
            if (getArguments().getString("title", "").isEmpty()) {
                view.findViewById(R.id.dialog_title).setVisibility(View.GONE);
                view.findViewById(R.id.dialog_message_layout).setVisibility(View.INVISIBLE);
            }
        }
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialogCallbackTwo != null)
                    dialogCallbackTwo.onButton1Pressed();
                dismiss();
            }
        });
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialogCallback != null)
                    dialogCallback.onButtonPressed(dialogEdit.getText().toString());
                if (dialogCallbackTwo != null)
                    dialogCallbackTwo.onButton2Pressed(dialogEdit.getText().toString());
                dismiss();
            }
        });
    }

    public void setDialogCallback(Callback callback) {
        this.dialogCallback = callback;
    }

    public interface Callback {
        void onButtonPressed(String text);
    }

    public interface CallbackTwo {
        void onButton1Pressed();

        void onButton2Pressed(String text);
    }
}
