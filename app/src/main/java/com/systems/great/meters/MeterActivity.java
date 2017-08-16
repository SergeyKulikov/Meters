package com.systems.great.meters;

import android.content.Context;
import android.content.Intent;
import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;

public class MeterActivity extends AppCompatActivity implements Utils {

    private String mSubTitle;
    private int mChoice;
    private ActionBar mActionBar;

    private final int mRowCount = 3;
    private ArrayList<EditText> etPreviousReading;
    private ArrayList<EditText> etCurrentReading;
    private ArrayList<EditText> etCurrentUnitPrice;
    private ArrayList<EditText> etCurrentSumm;

    static public Intent Init(Context context) {
        Intent intent = new Intent(context, MeterActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meter_activity);

        initUI();

        Intent intent = getIntent();
        mChoice = intent.getIntExtra(METER_TYPE, 0);

        switch (mChoice) {
            case R.id.nav_electricity:
                mSubTitle = getString(R.string.nav_electricity);
                break;
            case R.id.nav_water:
                mSubTitle = getString(R.string.nav_water);
                break;
            case R.id.nav_gas:
                mSubTitle = getString(R.string.nav_gas);
                break;
        }

        mActionBar = getActionBar();
        if (mActionBar != null) {
            mActionBar.setSubtitle(mSubTitle);
        }
        TextView tvType = (TextView) findViewById(R.id.tvType);
        tvType.setText(mSubTitle);
    }

    private void initUI() {
        etPreviousReading = new ArrayList<EditText>();
        etPreviousReading.add((EditText) findViewById(R.id.etPreviousReading1));
        etPreviousReading.add((EditText) findViewById(R.id.etPreviousReading2));
        etPreviousReading.add((EditText) findViewById(R.id.etPreviousReading3));

        etCurrentReading = new ArrayList<EditText>();
        etCurrentReading.add((EditText) findViewById(R.id.etCurrentReading1));
        etCurrentReading.add((EditText) findViewById(R.id.etCurrentReading2));
        etCurrentReading.add((EditText) findViewById(R.id.etCurrentReading3));

        etCurrentUnitPrice = new ArrayList<EditText>();
        etCurrentUnitPrice.add((EditText) findViewById(R.id.etCurrentUnitPrice1));
        etCurrentUnitPrice.add((EditText) findViewById(R.id.etCurrentUnitPrice2));
        etCurrentUnitPrice.add((EditText) findViewById(R.id.etCurrentUnitPrice3));

        etCurrentSumm = new ArrayList<EditText>();
        etCurrentSumm.add((EditText) findViewById(R.id.etCurrentSumm1));
        etCurrentSumm.add((EditText) findViewById(R.id.etCurrentSumm2));
        etCurrentSumm.add((EditText) findViewById(R.id.etCurrentSumm3));

        // If we change the number of rows, we also need to change the mLineCount.
        for (int i=0; i<mRowCount; i++) {
            final int finalI = i; // I don't why. Studio wants do that.

            etPreviousReading.get(i).setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    countRowSumm(finalI);
                    return false;
                }
            });

            etCurrentReading.get(i).setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    countRowSumm(finalI);
                    return false;
                }
            });

            etCurrentUnitPrice.get(i).setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    countRowSumm(finalI);
                    return false;
                }
            });

        }
    }

    private void countRowSumm(int row) {
        double mPreviousMeter = Double.parseDouble(etPreviousReading.get(row).getText().toString());
        double mCurrentMeter = Double.parseDouble(etCurrentReading.get(row).getText().toString());
        double mCurrentPrice = Double.parseDouble(etCurrentUnitPrice.get(row).getText().toString());

        double summ = (mCurrentMeter-mPreviousMeter)*mCurrentPrice;

        etCurrentSumm.get(row).setText(String.format("%.2f", summ));

        YoYo.with(Techniques.Tada).duration(700)
                .repeat(0)
                .playOn(etCurrentSumm.get(row));
    }

}
