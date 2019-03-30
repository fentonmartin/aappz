package io.github.fentonmartin.sample;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import io.github.fentonmartin.aappz.AappZ;
import io.github.fentonmartin.aappz.util.TextZ;

public class TextActivity extends AappZ {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* TextZ: Split and Join function --------------------------------------------------------*/
        setLog("============== TextZ: Split and Join =============================================");

        String test = "alpha, beta, charlie, delta, echo";
        setLog("TextZ Example: String test  = " + test);

        List<String> list = new ArrayList<>();
        setLog("TextZ Example: List<String> = " + list.size());

        list = TextZ.split(test, ",");
        setLog("TextZ Example: TextZ.split  = " + list.size());

        for (int i = 0; i < list.size(); i++)
            setLog("TextZ Example: Text " + i + " = " + list.get(i));

        test = TextZ.join(list, "|");
        setLog("TextZ Example: String test  = " + test);

        /* TextZ: setFormat function -------------------------------------------------------------*/
        setLog("============== TextZ: setFormat ==================================================");

        test = "soMe PEOPLE nAmE iN HeRe";
        setLog("TextZ Example: setFormatName  = " + TextZ.setFormatName(test));

        test = "soMe   PEOPLE   nAmE      iN  HeRe";
        setLog("TextZ Example: setFormatSpace = " + TextZ.setFormatSpace(test));

        test = "\nsoMe\nPEOPLE\n\n\nnAmE\niN\n\n\n\n\n\n\nHeRe";
        setLog("TextZ Example: test           = " + test);
        setLog("TextZ Example: setFormatSpace = " + TextZ.setFormatSpace(test));
        setLog("TextZ Example: setFormatEnter = " + TextZ.setFormatEnter(test));
        setLog("TextZ Example: setFormatAll   = " + TextZ.setFormatAll(test));

    }
}
