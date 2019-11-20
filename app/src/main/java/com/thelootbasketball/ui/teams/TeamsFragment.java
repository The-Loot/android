package com.thelootbasketball.ui.teams;
import com.thelootbasketball.APIInterface;
import com.thelootbasketball.APIClient;
import com.thelootbasketball.models.Team;

import java.util.List;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.thelootbasketball.R;

public class TeamsFragment extends Fragment {

    TableLayout team_table;
    APIInterface apiInterface;

//    private TeamsViewModel teamsViewModel;

//        teamsViewModel =
//                ViewModelProviders.of(this).get(TeamsViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_teams, container, false);
//        final TextView textView = root.findViewById(R.id.display_row);
//
//        teamsViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_teams, container, false);

        final TextView textView = root.findViewById(R.id.team_fragment);

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<Team>> call = apiInterface.getTeam();
        call.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                String displayResponse = "";
                List<Team> getTeam = response.body();

                for (int i = 0; i < getTeam.size(); i++){
                     displayResponse += getTeam.get(i).toString();
                    }
                textView.setTextSize(20);
                textView.setText(displayResponse);
                textView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent profile = new Intent(getActivity(), TeamProfileActivity.class);
                        startActivity(profile);
                    }
                    });
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                call.cancel();
            }
        });
        return root;
    }
}