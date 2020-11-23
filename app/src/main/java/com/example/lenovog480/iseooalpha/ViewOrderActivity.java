package com.example.lenovog480.iseooalpha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.lenovog480.iseooalpha.adapter.OrderAdapter;
import com.example.lenovog480.iseooalpha.api.APIService;
import com.example.lenovog480.iseooalpha.model.OrderModel;

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

public class ViewOrderActivity extends AppCompatActivity {

    @OnClick(R.id.back_arrow)void balik(){
        finish();
    }
    public static final String URL = "your_api";
    private List<OrderModel> orderList = new ArrayList<>();
    RecyclerView.LayoutManager mlayoutManager;
    private OrderAdapter viewAdapter;
    @BindView(R.id.recyclerViewOrder)RecyclerView recyclerView;
    @BindView(R.id.progress_bar)ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);
        ButterKnife.bind(this);

        viewAdapter = new OrderAdapter(ViewOrderActivity.this, orderList);
        mlayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mlayoutManager);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        APIService API = retrofit.create(APIService.class);
        Call<OrderModel> call = API.viewOrder();
        call.enqueue(new Callback<OrderModel>() {
            @Override
            public void onResponse(Call<OrderModel> call, Response<OrderModel> response) {
//                String value = response.body().getValue();
                progressBar.setVisibility(View.GONE);
                //             if(value.equals("success")){
                orderList = response.body().getResult();
                viewAdapter = new OrderAdapter(ViewOrderActivity.this, orderList);
                recyclerView.setAdapter(viewAdapter);
                viewAdapter.notifyDataSetChanged();
            }
            //        }

            @Override
            public void onFailure(Call<OrderModel> call, Throwable t) {

            }
        });


        // loadEvent();

    }

    @Override
    protected void onResume(){
        super.onResume();
        // loadEvent();
    }
    }

