package com.example.lenovog480.iseooalpha;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class DetailRequestActivity extends AppCompatActivity {

    String Order, Status;
    String a = "approve";
    String b = "not approve";
    Button press, pressN;
    public final String URL = "your_api";
    public ProgressDialog progressDialog;
    @OnClick(R.id.back_arrow)void balik(){
        finish();
    }
    @BindView(R.id.txtIdOrder)TextView id_Req;
    @BindView(R.id.txtNamaEvent)TextView namaEvent;
    @BindView(R.id.txtJenisEvent)TextView Jenisevent;
    @BindView(R.id.txtCreator)TextView creator;
    @BindView(R.id.txtNamaJasa)TextView namaSpons;
    @BindView(R.id.txtLamaEvent)TextView lamaEvent;
    @BindView(R.id.txtNamaTgglMulai)TextView Mulai;
    @BindView(R.id.txtNamaTgglOrder)TextView order;
    @BindView(R.id.txtStatus)TextView status;
    @BindView(R.id.id_order)EditText id_order;
    @BindView(R.id.id_status)EditText id_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_request);
        ButterKnife.bind(this);

        String id_req = getIntent().getExtras().getString("id_request");
        String namaevent = getIntent().getExtras().getString("nama_event");
        String jenisevent = getIntent().getExtras().getString("jenis_event");
        String create = getIntent().getExtras().getString("creator");
        String namajasa = getIntent().getExtras().getString("nama_spons");
        String lamaevent = getIntent().getExtras().getString("lama_event");
        String tgglM = getIntent().getExtras().getString("tanggal_mulai");
        String tgglO = getIntent().getExtras().getString("tanggal_order");
        String stat = getIntent().getExtras().getString("status");

        id_Req.setText(id_req);
        namaEvent.setText(namaevent);
        Jenisevent.setText(jenisevent);
        creator.setText(create);
        namaSpons.setText(namajasa);
        lamaEvent.setText(lamaevent);
        Mulai.setText(tgglM);
        order.setText(tgglO);
        status.setText(stat);

        press = (Button)findViewById(R.id.BtnApprove);
        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(DetailRequestActivity.this);
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
                Call<ApiResponseModel> call = api.updateRequest(Order, Status);
                call.enqueue(new Callback<ApiResponseModel>() {
                    @Override
                    public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
//                        String value = response.body().getStatus();
                        progressDialog.dismiss();
                        //status.setText(a);
                        // if (value.equals("success")){
                        Toast.makeText(DetailRequestActivity.this, "Data Sukses Di Ubah", Toast.LENGTH_LONG).show();
                        Intent perbarui = new Intent(DetailRequestActivity.this, ViewRequestActivity.class);
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
                        Toast.makeText(DetailRequestActivity.this, "Connectivity Error", Toast.LENGTH_LONG).show();

                    }
                });

            }

        });
        pressN = (Button)findViewById(R.id.BtnNApprove);
        pressN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(DetailRequestActivity.this);
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
                Call<ApiResponseModel> call = api.updateRequest(Order, Status);
                call.enqueue(new Callback<ApiResponseModel>() {
                    @Override
                    public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
//                        String value = response.body().getStatus();
                        progressDialog.dismiss();
                        //status.setText(a);
                        // if (value.equals("success")){
                        Toast.makeText(DetailRequestActivity.this, "Data Sukses Di Ubah", Toast.LENGTH_LONG).show();
                        Intent perbarui = new Intent(DetailRequestActivity.this, ViewRequestActivity.class);
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
                        Toast.makeText(DetailRequestActivity.this, "Connectivity Error", Toast.LENGTH_LONG).show();

                    }
                });

            }

        });
    };

}
