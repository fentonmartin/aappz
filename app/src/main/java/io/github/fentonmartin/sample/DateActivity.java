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
        binding.label1.setText(DateZ.RANGE_1);
        binding.label2.setText(DateZ.RANGE_2);
        binding.label3.setText(DateZ.RANGE_3);
        binding.label4.setText(DateZ.RANGE_4);
        binding.label5.setText(DateZ.RANGE_5);
        binding.label6.setText(DateZ.RANGE_6);
        binding.label7.setText(DateZ.RANGE_7);
        binding.label8.setText(DateZ.RANGE_8);
        binding.label9.setText(DateZ.RANGE_9);
        binding.label10.setText(DateZ.RANGE_10);
        binding.label11.setText(DateZ.RANGE_11);
        binding.label12.setText(DateZ.RANGE_12);
        binding.label13.setText(DateZ.RANGE_13);
        binding.label14.setText(DateZ.RANGE_14);
        binding.label15.setText("CUSTOM_45");
        binding.label16.setText("CUSTOM_46");
        binding.label17.setText("CUSTOM_47");
        binding.label18.setText("CUSTOM_48");
        binding.label19.setText("CUSTOM_49");
        binding.label20.setText("CUSTOM_50");
        
        long time = 3893465000L;

//        binding.text1.setText(DateZ.getTimeRangeFrom(time, DateZ.RANGE_1));
        binding.text2.setText(DateZ.getTimeRangeFrom(time, DateZ.RANGE_2));
//        binding.text3.setText(DateZ.getTimeRangeFrom(time, DateZ.RANGE_3));
        binding.text4.setText(DateZ.getTimeRangeFrom(time, DateZ.RANGE_4));
//        binding.text5.setText(DateZ.getTimeRangeFrom(time, DateZ.RANGE_5));
        binding.text6.setText(DateZ.getTimeRangeFrom(time, DateZ.RANGE_6));
//        binding.text7.setText(DateZ.getTimeRangeFrom(time, DateZ.RANGE_7));
        binding.text8.setText(DateZ.getTimeRangeFrom(time, DateZ.RANGE_8));
//        binding.text9.setText(DateZ.getTimeRangeFrom(time, DateZ.RANGE_9));
        binding.text10.setText(DateZ.getTimeRangeFrom(time, DateZ.RANGE_10));
//        binding.text11.setText(DateZ.getTimeRangeFrom(time, DateZ.RANGE_11));
        binding.text12.setText(DateZ.getTimeRangeFrom(time, DateZ.RANGE_12));
//        binding.text13.setText(DateZ.getTimeRangeFrom(time, DateZ.RANGE_13));
        binding.text14.setText(DateZ.getTimeRangeFrom(time, DateZ.RANGE_14));
        binding.text15.setText(DateZ.getDateTime(DateConstant.CUSTOM_45));
        binding.text16.setText(DateZ.getDateTime(DateConstant.CUSTOM_46));
        binding.text17.setText(DateZ.getDateTime(DateConstant.CUSTOM_47));
        binding.text18.setText(DateZ.getDateTime(DateConstant.CUSTOM_48));
        binding.text19.setText(DateZ.getDateTime(DateConstant.CUSTOM_49));
        binding.text20.setText(DateZ.getDateTime(DateConstant.CUSTOM_50));
    }
}
