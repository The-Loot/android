package com.thelootbasketball.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.thelootbasketball.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class ScheduleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        final View root = inflater.inflate(R.layout.fragment_schedule, container, false);
        final TextView textView = root.findViewById(R.id.week_of);
        final Button previousButton = root.findViewById(R.id.button);

        Calendar cal = Calendar.getInstance(Locale.getDefault());
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yy", Locale.getDefault());
        //get first day of the week
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        final String FirstDayOfWeek = df.format(cal.getTime());
        //get the last day of the week
        cal.add(Calendar.DATE, 6);
        final String LastDayOfWeek = df.format(cal.getTime());


        textView.setText("Week of: " + FirstDayOfWeek + " to "+ LastDayOfWeek);


        return root;
    }
}
