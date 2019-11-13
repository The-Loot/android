package com.thelootbasketball.ui.teams;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.thelootbasketball.APIClient;
import com.thelootbasketball.APIInterface;
import com.thelootbasketball.models.Teams;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    APIInterface apiInterface;

    public TeamsViewModel() {
        mText = new MutableLiveData<>();
//        apiInterface = APIClient.getClient().create(APIInterface.class);
//        Call<List<Teams>> call = apiInterface.getTeams();
//        call.enqueue(new Callback<List<Teams>>() {
//            @Override
//            public void onResponse(Call<List<Teams>> call, Response<List<Teams>> response) {
//                String displayResponse = "";
//                List<Teams> getTeams = response.body();
//
//                for (int i = 0; i < getTeams.size(); i++){
//                    displayResponse += getTeams.get(i).toString();
//                }
//                mText.setValue(displayResponse);
//            }
//
//            @Override
//            public void onFailure(Call<List<Teams>> call, Throwable t) {
//                call.cancel();
//            }
//        });
    }

    public LiveData<String> getText() {
        return mText;
    }
}