package io.github.fentonmartin.sample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import io.github.fentonmartin.aappz.AappZ;
import io.github.fentonmartin.aappz.constant.DateConstant;
import io.github.fentonmartin.aappz.util.DateZ;
import io.github.fentonmartin.sample.databinding.ActivityDateBinding;

public class DateActivity extends AappZ {

    private ActivityDateBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        onCheck();
    }

    public void onCheck(View view) {
        onCheck();
    }

    private void onCheck() {
        binding.text1.setText(DateZ.getDatetime(DateConstant.CUSTOM_31));
        binding.text2.setText(DateZ.getDatetime(DateConstant.CUSTOM_32));
        binding.text3.setText(DateZ.getDatetime(DateConstant.CUSTOM_33));
        binding.text4.setText(DateZ.getDatetime(DateConstant.CUSTOM_34));
        binding.text5.setText(DateZ.getDatetime(DateConstant.CUSTOM_35));
        binding.text6.setText(DateZ.getDatetime(DateConstant.CUSTOM_36));
        binding.text7.setText(DateZ.getDatetime(DateConstant.CUSTOM_37));
        binding.text8.setText(DateZ.getDatetime(DateConstant.CUSTOM_38));
        binding.text9.setText(DateZ.getDatetime(DateConstant.CUSTOM_39));
        binding.text10.setText(DateZ.getDatetime(DateConstant.CUSTOM_40));
        binding.text11.setText(DateZ.getDatetime(DateConstant.CUSTOM_41));
        binding.text12.setText(DateZ.getDatetime(DateConstant.CUSTOM_42));
        binding.text13.setText(DateZ.getDatetime(DateConstant.CUSTOM_43));
        binding.text14.setText(DateZ.getDatetime(DateConstant.CUSTOM_44));
        binding.text15.setText(DateZ.getDatetime(DateConstant.CUSTOM_45));
        binding.text16.setText(DateZ.getDatetime(DateConstant.CUSTOM_46));
        binding.text17.setText(DateZ.getDatetime(DateConstant.CUSTOM_47));
        binding.text18.setText(DateZ.getDatetime(DateConstant.CUSTOM_48));
        binding.text19.setText(DateZ.getDatetime(DateConstant.CUSTOM_49));
        binding.text20.setText(DateZ.getDatetime(DateConstant.CUSTOM_50));
    }
}
