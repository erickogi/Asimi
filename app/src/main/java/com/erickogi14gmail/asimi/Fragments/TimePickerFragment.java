package com.erickogi14gmail.asimi.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by denis on 4/26/17.
 */

public class TimePickerFragment extends DialogFragment {
    private Activity mActivity;
    private TimePickerDialog.OnTimeSetListener mlistener;



    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
        try {
            mlistener = (TimePickerDialog.OnTimeSetListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString()+ " must implement OnDateSetListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //use of current time as default

            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(mActivity, mlistener, hour, minute, DateFormat.is24HourFormat(getActivity()));

    }


}
