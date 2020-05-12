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

    @SuppressLint("SetTextI18n")
    private void onCheck() {
        binding.label1.setText("CUSTOM_31");
        binding.label2.setText("CUSTOM_32");
        binding.label3.setText("CUSTOM_33");
        binding.label4.setText("CUSTOM_34");
        binding.label5.setText("CUSTOM_35");
        binding.label6.setText("CUSTOM_36");
        binding.label7.setText("CUSTOM_37");
        binding.label8.setText("CUSTOM_38");
        binding.label9.setText("CUSTOM_39");
        binding.label10.setText("CUSTOM_40");
        binding.label11.setText("CUSTOM_41");
        binding.label12.setText("CUSTOM_42");
        binding.label13.setText("CUSTOM_43");
        binding.label14.setText("CUSTOM_44");
        binding.label15.setText("CUSTOM_45");
        binding.label16.setText("CUSTOM_46");
        binding.label17.setText("CUSTOM_47");
        binding.label18.setText("CUSTOM_48");
        binding.label19.setText("CUSTOM_49");
        binding.label20.setText("CUSTOM_50");

        binding.text1.setText(DateZ.getTimeRangeFrom(1900631000L, DateZ.RANGE_1));
        binding.text2.setText(DateZ.getTimeRangeFrom(1900631000L, DateZ.RANGE_2));
        binding.text3.setText(DateZ.getTimeRangeFrom(1900631000L, DateZ.RANGE_6));
        binding.text4.setText(DateZ.getTimeRangeFrom(1900631000L, DateZ.RANGE_7));
        binding.text5.setText(DateZ.getTimeRangeFrom(1900631000L, DateZ.RANGE_8));
        binding.text6.setText(DateZ.getTimeRangeFrom(1900631000L, DateZ.RANGE_9));
        binding.text7.setText(DateZ.getTimeRangeFrom(1900631000L, DateZ.RANGE_10));
        binding.text8.setText(DateZ.getTimeRangeFrom(1900631000L, DateZ.RANGE_11));
        binding.text9.setText(DateZ.getTimeRangeFrom(1900631000L, DateZ.RANGE_12));
        binding.text10.setText(DateZ.getTimeRangeFrom(1900631000L, DateZ.RANGE_13));
        binding.text11.setText(DateZ.getDateTime(DateConstant.CUSTOM_41));
        binding.text12.setText(DateZ.getDateTime(DateConstant.CUSTOM_42));
        binding.text13.setText(DateZ.getDateTime(DateConstant.CUSTOM_43));
        binding.text14.setText(DateZ.getDateTime(DateConstant.CUSTOM_44));
        binding.text15.setText(DateZ.getDateTime(DateConstant.CUSTOM_45));
        binding.text16.setText(DateZ.getDateTime(DateConstant.CUSTOM_46));
        binding.text17.setText(DateZ.getDateTime(DateConstant.CUSTOM_47));
        binding.text18.setText(DateZ.getDateTime(DateConstant.CUSTOM_48));
        binding.text19.setText(DateZ.getDateTime(DateConstant.CUSTOM_49));
        binding.text20.setText(DateZ.getDateTime(DateConstant.CUSTOM_50));
    }
}
