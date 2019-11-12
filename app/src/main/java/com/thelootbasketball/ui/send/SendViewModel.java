package com.thelootbasketball.ui.send;

import com.thelootbasketball.APIInterface;
import com.thelootbasketball.APIClient;
import com.thelootbasketball.models.Player;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;


public class SendViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    APIInterface apiInterface;

    public SendViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is send fragment");

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<Player>> call = apiInterface.getPlayers();
        call.enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {

                String displayResponse = "";

                List<Player> getPlayers = response.body();

                for(int i = 0; i < getPlayers.size(); i++){
                    displayResponse += getPlayers.get(i).toString();
                }
                mText.setValue(displayResponse);
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {
                call.cancel();
            }
        });
    }
    public LiveData<String> getText() {
        return mText;
    }
}