package com.example.lenovog480.iseooalpha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.lenovog480.iseooalpha.adapter.RecyclerViewAdapter;
import com.example.lenovog480.iseooalpha.api.APIService;
import com.example.lenovog480.iseooalpha.model.ApiResponseModel;
import com.example.lenovog480.iseooalpha.model.EventModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ViewEventActivity extends AppCompatActivity {

    //String nama_event, jenis_event, creator_event, desk_event, tanggal_event;
    //String nama_event;

    @OnClick(R.id.back_arrow)void balik(){
        finish();
    }
    @BindView(R.id.search_acara)EditText searchEvent;
    public static final String URL = "your_api";
    private List<EventModel> acara = new ArrayList<>();
    //private RecyclerView.Adapter viewAdapter;
    RecyclerView.LayoutManager mlayoutManager;
    private RecyclerViewAdapter viewAdapter;
    @BindView(R.id.recyclerViewEvent)RecyclerView recyclerView;
    @BindView(R.id.progress_bar)ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);
        ButterKnife.bind(this);

        viewAdapter = new RecyclerViewAdapter(ViewEventActivity.this, acara);
        mlayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mlayoutManager);
    //    recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);

       Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        APIService API = retrofit.create(APIService.class);
        Call<ApiResponseModel> getData = API.viewEvent();
        getData.enqueue(new Callback<ApiResponseModel>() {
            @Override
            public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
//                String value = response.body().getValue();
                progressBar.setVisibility(View.GONE);
  //              if(value.equals("success")){
                    acara = response.body().getResult();
                    viewAdapter = new RecyclerViewAdapter(ViewEventActivity.this, acara);
                    recyclerView.setAdapter(viewAdapter);
                    viewAdapter.notifyDataSetChanged();
                }
    //        }

            @Override
            public void onFailure(Call<ApiResponseModel> call, Throwable t) {

            }
        });


       // loadEvent();

    }

    @Override
    protected void onResume(){
        super.onResume();
       // loadEvent();
    }

   /* private void loadEvent(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        APIService api = retrofit.create(APIService.class);
        Call<ApiResponseModel> call = api.viewEvent();
        call.enqueue(new Callback<ApiResponseModel>() {
            @Override
            public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
                String value = response.body().getValue();
                progressBar.setVisibility(View.GONE);
                if(value.equals("1")){
                    acara = response.body().getResult();
                    viewAdapter = new RecyclerViewAdapter(ViewEventActivity.this, acara);
                    recyclerView.setAdapter(viewAdapter);
                }
            }

            @Override
            public void onFailure(Call<ApiResponseModel> call, Throwable t) {

            }
        });*/
   // }
}




