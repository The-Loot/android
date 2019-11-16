package com.thelootbasketball.ui.teams;
import com.thelootbasketball.APIInterface;
import com.thelootbasketball.APIClient;
import com.thelootbasketball.models.Teams;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.thelootbasketball.R;

import org.w3c.dom.Text;

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
        Call<List<Teams>> call = apiInterface.getTeams();
        call.enqueue(new Callback<List<Teams>>() {
            @Override
            public void onResponse(Call<List<Teams>> call, Response<List<Teams>> response) {
                String displayResponse = "";
                List<Teams> getTeams = response.body();

                for (int i = 0; i < getTeams.size(); i++){
                     displayResponse += getTeams.get(i).toString();
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
            public void onFailure(Call<List<Teams>> call, Throwable t) {
                call.cancel();
            }
        });

        return root;
    }
}