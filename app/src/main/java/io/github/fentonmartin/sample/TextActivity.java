package io.github.fentonmartin.sample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

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

        list = TextZ.getListFrom(test, ",");
        setLog("TextZ Example: TextZ.getListFrom  = " + list.size());

        for (int i = 0; i < list.size(); i++)
            setLog("TextZ Example: Text " + i + " = " + list.get(i));

        test = TextZ.getStringFrom(list, "|");
        setLog("TextZ Example: String test  = " + test);

        /* TextZ: setFormat function -------------------------------------------------------------*/
        setLog("============== TextZ: setFormat ==================================================");

        test = "soMe PEOPLE nAmE iN HeRe";
        setLog("TextZ Example: getFormatName  = " + TextZ.getFormatName(test));

        test = "soMe   PEOPLE   nAmE      iN  HeRe";
        setLog("TextZ Example: getFormatSpace = " + TextZ.getFormatSpace(test));

        test = "\nsoMe\nPEOPLE\n\n\nnAmE\niN\n\n\n\n\n\n\nHeRe";
        setLog("TextZ Example: test           = " + test);
        setLog("TextZ Example: getFormatSpace = " + TextZ.getFormatSpace(test));
        setLog("TextZ Example: getFormatEnter = " + TextZ.getFormatEnter(test));
        setLog("TextZ Example: getFormatAll   = " + TextZ.getFormatAll(test));

        /* TextZ: setFormat function -------------------------------------------------------------*/
        setLog("============== TextZ: getNumberFormat ============================================");

        test = "1000000000";
        setLog("TextZ Example: getNumberFormat = " + TextZ.getNumberFormat(test));
        setLog("TextZ Example: getNumberFormat = " + TextZ.getNumberFormat(test, false));
        setLog("TextZ Example: getNumberFormat = " + TextZ.getNumberFormat(test, true));

        double number = 10000.12345;
        setLog("TextZ Example: getNumber        = " + TextZ.getNumber(String.valueOf(number)));
        setLog("TextZ Example: getNumberFormat  = " + TextZ.getNumberFormat(String.valueOf(number)));
        setLog("TextZ Example: getNumberFormat  = " + TextZ.getNumberFormat(String.valueOf(number), true));
        setLog("TextZ Example: getDecimalFormat = " + TextZ.getDecimalFormat(number, 2));
        setLog("TextZ Example: getDecimalFormat = " + TextZ.getDecimalFormat(number, 4));
        setLog("TextZ Example: getDecimalFormat = " + TextZ.getDecimalFormat(number, 1));

        int money = 3450000;
        setLog("TextZ Example: getMoneyFormat   = " + TextZ.getMoneyFormat(String.valueOf(money)));
        setLog("TextZ Example: getMoneyFormat   = " + TextZ.getMoneyFormat(String.valueOf(money), false));
        setLog("TextZ Example: getMoneyFormat   = " + TextZ.getMoneyFormat(String.valueOf(money), true));
        setLog("TextZ Example: getMoneyFormat   = " + TextZ.getMoneyFormat("IDR ", String.valueOf(money)));
        setLog("TextZ Example: getMoneyFormat   = " + TextZ.getMoneyFormat("IDR ", String.valueOf(money), false));
        setLog("TextZ Example: getMoneyFormat   = " + TextZ.getMoneyFormat("IDR ", String.valueOf(money), true));
        setLog("TextZ Example: getMoneyFormat   = " + TextZ.getMoneyFormat("", String.valueOf(money), " rupiah"));
        setLog("TextZ Example: getMoneyFormat   = " + TextZ.getMoneyFormat("", String.valueOf(money), " rupiah", false));
        setLog("TextZ Example: getMoneyFormat   = " + TextZ.getMoneyFormat("", String.valueOf(money), " rupiah", true));

    }

    public void onBounceClick(View view) {
        setLog("onBounceClick: onClicked");
        setViewBounce(view);
    }

    public void onLoadingClick(View view) {
        setLog("onLoadingClick: onClicked");
    }
}
