//package com.thelootbasketball.ui.teams;
//
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
//import androidx.lifecycle.ViewModel;
//
//import com.thelootbasketball.APIClient;
//import com.thelootbasketball.APIInterface;
//import com.thelootbasketball.models.Team;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class TeamsViewModel extends ViewModel {
//
//    private MutableLiveData<String> mText;
//
//    APIInterface apiInterface;
//
//    public TeamsViewModel() {
//        mText = new MutableLiveData<>();
//
//        apiInterface = APIClient.getClient().create(APIInterface.class);
//        Call<List<Team>> call = apiInterface.getTeams();
//        call.enqueue(new Callback<List<Team>>() {
//            @Override
//            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
//                String displayResponse = "";
//                List<Team> getTeams = response.body();
//
//                for (int i = 0; i < getTeams.size(); i++){
//                    displayResponse += getTeams.get(i).toString();
//                }
//                mText.setValue(displayResponse);
//            }
//
//            @Override
//            public void onFailure(Call<List<Team>> call, Throwable t) {
//                call.cancel();
//            }
//        });
//    }
//
//    public LiveData<String> getText() {
//        return mText;
//    }
//}