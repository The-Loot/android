package com.thelootbasketball.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.thelootbasketball.R;

import java.util.Calendar;

public class ScheduleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        final View root = inflater.inflate(R.layout.fragment_schedule, container, false);
         final TextView textView = root.findViewById(R.id.week_of);

        Calendar cal = Calendar.getInstance();
        int WeekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);

        textView.setText(Integer.toString(WeekOfMonth));

        return root;
    }
}
