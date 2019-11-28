package com.thelootbasketball.ui.teams;
import com.thelootbasketball.APIInterface;
import com.thelootbasketball.APIClient;
import com.thelootbasketball.models.Team;
import com.thelootbasketball.models.TeamInfo;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.thelootbasketball.R;


public class TeamsFragment extends Fragment {
    TableLayout team_table;
    APIInterface apiInterface;
    TeamInfo t = TeamInfo.getInstance();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_teams, container, false);
       team_table = root.findViewById(R.id.teams);
       // final TextView textView = root.findViewById(R.id.team_fragment);

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<Team>> call = apiInterface.getTeam();
        call.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                List<Team> getTeam = response.body(); //retrieve JSON objects
                for (int i = 0; i < getTeam.size(); i++) {
                    t.addTeam(getTeam.get(i)); //add teams into Team object from TeamInfo
                }

                final List<Team> teams = t.getData();

                for (int i = 0; i < teams.size(); i++) {
                    TableRow row = new TableRow(getActivity());
                    row.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                    row.setId(i);
                    final String team_name = teams.get(i).getTeamName();
                    TextView team_info = new TextView(getActivity());
                    team_info.setId(i);
                    team_info.setTextAppearance(R.style.TeamListStyle);
                    team_info.setPadding(10,20,0,20);
                    team_info.setText(team_name);
                    team_info.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent profile = new Intent(getActivity(), TeamProfileActivity.class);
                            profile.putExtra("teamName", team_name);
                            startActivity(profile);
                        }
                    });
                    row.addView(team_info);
                    team_table.addView(row, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                }
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                call.cancel();
            }
        });
        return root;
    }
}