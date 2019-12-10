package com.thelootbasketball.ui.schedule;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.thelootbasketball.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class ScheduleFragment extends Fragment {
    private Calendar cal = Calendar.getInstance(Locale.US);
    public String getCurrentWeek(){
        cal = Calendar.getInstance(Locale.US);
        cal.setFirstDayOfWeek(Calendar.SUNDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return getNextWeek();
    }

    public String getNextWeek(){
        DateFormat df = new SimpleDateFormat("MM/dd/yy");
        String[] days = new String[7];
        for (int i = 0; i < 7; i++){
            days[i] = df.format(this.cal.getTime());
            cal.add(Calendar.DATE, 1);
        }
            String firstDayOfWeek = days[0];
            String LastDayOfWeek = days[days.length - 1];
            String WeekOf = "Week of: " + firstDayOfWeek + " to " + LastDayOfWeek;
            return WeekOf;
    }

    public String getPreviousWeek() {
        cal.add(Calendar.DATE, -14);
        return getNextWeek();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        final View root = inflater.inflate(R.layout.fragment_schedule, container, false);
        final TextView textView = root.findViewById(R.id.week_of);
        final TextView textView1 = root.findViewById(R.id.testing);
        final ImageButton previousButton = root.findViewById(R.id.previous_button);
        final ImageButton nextButton = root.findViewById(R.id.forward_button);

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    textView.setText(getPreviousWeek());
                }
        });
        textView.append(getCurrentWeek());

        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    textView.setText(getNextWeek());
            }
        });

        textView1.setText("Testing");

        return root;
    }
}
