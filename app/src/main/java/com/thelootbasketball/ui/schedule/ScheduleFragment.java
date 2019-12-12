package com.thelootbasketball.ui.schedule;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.thelootbasketball.APIClient;
import com.thelootbasketball.APIInterface;
import com.thelootbasketball.models.Schedule;
import com.thelootbasketball.R;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ScheduleFragment extends Fragment {
    APIInterface apiInterface;

    private Calendar cal = Calendar.getInstance(Locale.US);
    private String getCurrentWeek(){
        cal = Calendar.getInstance(Locale.US);
        cal.setFirstDayOfWeek(Calendar.SUNDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return getNextWeek();
    }

    private String getNextWeek(){
        DateFormat df = new SimpleDateFormat("MM/dd/yy", Locale.US);
        String[] days = new String[7];
        for (int i = 0; i < 7; i++){
            days[i] = df.format(this.cal.getTime());
            cal.add(Calendar.DATE, 1);
        }
            String firstDayOfWeek = days[0];
            String LastDayOfWeek = days[days.length - 1];
            return "Week of: " + firstDayOfWeek + " to " + LastDayOfWeek;
    }

    private String getPreviousWeek() {
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
        TableRow schedule_row = root.findViewById(R.id.schedule);

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

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<Schedule>> call = apiInterface.getSchedule();
        call.enqueue(new Callback<List<Schedule>>() {
            @Override
            public void onResponse(Call<List<Schedule>> call, Response<List<Schedule>> response) {
               List<Schedule> getSchedule = response.body();
                for (int i = 0; i < getSchedule.size(); i++){
                    String schedule_date = getSchedule.get(i).getDate();
                    try {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z", Locale.getDefault());
                        Date date = simpleDateFormat.parse(schedule_date);
                        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yy KK:mm a", Locale.getDefault());
                        String formattedDate = df.format(date);
                        textView1.setText(formattedDate);
                    } catch(ParseException e){
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Schedule>> call, Throwable t) {
                    call.cancel();
            }
        });
        return root;
    }
}
