package com.example.lenovog480.iseooalpha;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovog480.iseooalpha.api.APIService;
import com.example.lenovog480.iseooalpha.model.ApiResponseModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailOrderActivity extends AppCompatActivity {

    String Order, Status;
    String a = "approve";
    String b = "not approve";
    Button press, pressN;
    public final String URL = "your_api";
    public ProgressDialog progressDialog;
    @OnClick(R.id.back_arrow)void balik(){
        finish();
    }
    @BindView(R.id.txtIdOrder)TextView idO;
    @BindView(R.id.txtNamaEventOrder)TextView namaEvent;
    @BindView(R.id.txtCreator)TextView creator;
    @BindView(R.id.txtNamaJasa)TextView namaJasa;
    @BindView(R.id.txtLamaEvent)TextView lamaEvent;
    @BindView(R.id.txtNamaTgglMulai)TextView Mulai;
    @BindView(R.id.txtNamaTgglOrder)TextView order;
    @BindView(R.id.txtStatus)TextView status;
    @BindView(R.id.id_order)EditText id_order;
    @BindView(R.id.id_status)EditText id_status;



    /*@OnClick(R.id.BtnApprove)void approve(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();


        Status = getIntent().getExtras().getString("status");
        status.setText(a);

        Retrofit update = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        APIService api = update.create(APIService.class);
        Call<ApiResponseModel>call = api.updateOrder(Status);
        call.enqueue(new Callback<ApiResponseModel>() {
            @Override
            public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
                //String value = response.body().getStatus();
                progressDialog.dismiss();
               // if (value.equals("success")){
                    Toast.makeText(DetailOrderActivity.this, "Data Sukses Di Ubah", Toast.LENGTH_LONG).show();
                    Intent perbarui = new Intent(DetailOrderActivity.this, DetailOrderActivity.class);
                    startActivity(perbarui);
                    finish();
                //}else {
                  //  Toast.makeText(DetailOrderActivity.this, "Maaf Coba lagi!", Toast.LENGTH_LONG).show();
                //}
            }

            @Override
            public void onFailure(Call<ApiResponseModel> call, Throwable t) {
                t.printStackTrace();
                progressDialog.dismiss();
                Toast.makeText(DetailOrderActivity.this, "Connectivity Error", Toast.LENGTH_LONG).show();

            }
        });

    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_order);
        ButterKnife.bind(this);

        String id = getIntent().getExtras().getString("id_order");
        String namaevent = getIntent().getExtras().getString("nama_event");
        String create = getIntent().getExtras().getString("creator");
        String namajasa = getIntent().getExtras().getString("nama_jasa");
        String lamaevent = getIntent().getExtras().getString("lama_event");
        String tgglM = getIntent().getExtras().getString("tanggal_mulai");
        String tgglO = getIntent().getExtras().getString("tanggal_order");
        final String stat = getIntent().getExtras().getString("status");

        idO.setText(id);
        namaEvent.setText(namaevent);
        creator.setText(create);
        namaJasa.setText(namajasa);
        lamaEvent.setText(lamaevent);
        Mulai.setText(tgglM);
        order.setText(tgglO);
        status.setText(stat);

        press = (Button)findViewById(R.id.BtnApprove);
        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(DetailOrderActivity.this);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Loading.....");
                progressDialog.show();

                //status.setText(a);
                //Status = status.getText().toString();
                //status.setText(a);
                Order = id_order.getText().toString();
                id_status.setText(a);
                Status = id_status.getText().toString();

                Retrofit update = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
                APIService api = update.create(APIService.class);
                Call<ApiResponseModel> call = api.updateOrder(Order, Status);
                call.enqueue(new Callback<ApiResponseModel>() {
                    @Override
                    public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
//                        String value = response.body().getStatus();
                        progressDialog.dismiss();
                        //status.setText(a);
                       // if (value.equals("success")){
                        Toast.makeText(DetailOrderActivity.this, "Data Sukses Di Ubah", Toast.LENGTH_LONG).show();
                        Intent perbarui = new Intent(DetailOrderActivity.this, ViewOrderActivity.class);
                        startActivity(perbarui);
                        finish();
                        //}else {
                         // Toast.makeText(DetailOrderActivity.this, "Maaf Coba lagi!", Toast.LENGTH_LONG).show();
                        }
                    //}

                    @Override
                    public void onFailure(Call<ApiResponseModel> call, Throwable t) {
                        t.printStackTrace();
                        progressDialog.dismiss();
                        Toast.makeText(DetailOrderActivity.this, "Connectivity Error", Toast.LENGTH_LONG).show();

                    }
                });

            }

            });
        pressN = (Button)findViewById(R.id.BtnNApprove);
        pressN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(DetailOrderActivity.this);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Loading.....");
                progressDialog.show();

                //status.setText(a);
                //Status = status.getText().toString();
                //status.setText(a);
                Order = id_order.getText().toString();
                id_status.setText(b);
                Status = id_status.getText().toString();

                Retrofit update = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
                APIService api = update.create(APIService.class);
                Call<ApiResponseModel> call = api.updateOrder(Order, Status);
                call.enqueue(new Callback<ApiResponseModel>() {
                    @Override
                    public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
//                        String value = response.body().getStatus();
                        progressDialog.dismiss();
                        //status.setText(a);
                        // if (value.equals("success")){
                        Toast.makeText(DetailOrderActivity.this, "Data Sukses Di Ubah", Toast.LENGTH_LONG).show();
                        Intent perbarui = new Intent(DetailOrderActivity.this, ViewOrderActivity.class);
                        startActivity(perbarui);
                        finish();
                        //}else {
                        // Toast.makeText(DetailOrderActivity.this, "Maaf Coba lagi!", Toast.LENGTH_LONG).show();
                    }
                    //}

                    @Override
                    public void onFailure(Call<ApiResponseModel> call, Throwable t) {
                        t.printStackTrace();
                        progressDialog.dismiss();
                        Toast.makeText(DetailOrderActivity.this, "Connectivity Error", Toast.LENGTH_LONG).show();

                    }
                });

            }

        });
        };

    }

