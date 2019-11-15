package com.thelootbasketball.ui.teams;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.thelootbasketball.R;

public class TeamsFragment extends Fragment {

    TableLayout team_table;

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

        final TextView textView = root.findViewById(R.id.testing);
        textView.setText("Testing 1 ....2 ....3");
        return root;
    }
}