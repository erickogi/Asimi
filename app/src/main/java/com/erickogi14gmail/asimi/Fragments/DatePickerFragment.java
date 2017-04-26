package com.erickogi14gmail.asimi.Fragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by denis on 4/26/17.
 */

public class DatePickerFragment extends DialogFragment {
    private Activity mActivity;
    private DatePickerDialog.OnDateSetListener mlistener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
        try {
            mlistener = (DatePickerDialog.OnDateSetListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString()+ " must implement OnDateSetListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(mActivity, mlistener, year, month, day);
    }


}
