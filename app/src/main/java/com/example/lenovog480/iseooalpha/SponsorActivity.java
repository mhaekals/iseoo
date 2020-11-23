package com.example.lenovog480.iseooalpha;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
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

public class SponsorActivity extends AppCompatActivity {
    public ProgressDialog progressDialog;
    public final String URL = "your_api";
    String nama_sponsor, kontak_sponsor, jenis_sponsor, desk_sponsor, untuk_event, pemilik_sponsor;

    @OnClick(R.id.back_arrow) void balik(){
        finish();
    }

    @BindView(R.id.sponsor_name)EditText namaJasa;
    @BindView(R.id.kontak_sponsor)EditText kontakJasa;
    @BindView(R.id.spinnerJenisSponsor)Spinner spinnerJenisSpons;
    //@BindView(R.id.jenis_sponsor)EditText jenisJasa;
    @BindView(R.id.deskripsi_sponsor)EditText deskJasa;
    @BindView(R.id.spinnerJenisEvent)Spinner spinnerJenisEvent;
    //@BindView(R.id.jasa_jenisSponsor)EditText jenisEvent;
    @BindView(R.id.pemilik_sponsor)EditText pemilikJasa;

    private String[] items = new String[]{"Sponsor Tunggal", "Sponsor Utama", "Sponsor Madya", "Sponsor Partisipan"};
    int a = 1;
    int b = 2;
    int c = 3;
    int d = 4;
    int e = 5;
    private String[] itemss = new String[]{"All Event", "Musik", "Seminar", "Pameran", "Pagelaran"};

    @OnClick(R.id.submit_sponsor)void submitJasa(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();

        nama_sponsor = namaJasa.getText().toString();
        kontak_sponsor = kontakJasa.getText().toString();
        items[0] = String.valueOf(a);
        items[1] = String.valueOf(b);
        items[2] = String.valueOf(c);
        items[3] = String.valueOf(d);
        jenis_sponsor = String.valueOf(spinnerJenisSpons.getSelectedItem());

        itemss[0] = String.valueOf(a);
        itemss[1] = String.valueOf(b);
        itemss[2] = String.valueOf(c);
        itemss[3] = String.valueOf(d);
        itemss[4] = String.valueOf(e);
        untuk_event = String.valueOf(spinnerJenisEvent.getSelectedItem());
        //jenis_sponsor = jenisJasa.getText().toString();
        desk_sponsor = deskJasa.getText().toString();
       // untuk_event = jenisEvent.getText().toString();
        pemilik_sponsor = pemilikJasa.getText().toString();

        Retrofit acara = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        APIService api = acara.create(APIService.class);
        Call<ApiResponseModel> call = api.newSponsor(nama_sponsor, kontak_sponsor, jenis_sponsor, desk_sponsor, untuk_event, pemilik_sponsor);
        call.enqueue(new Callback<ApiResponseModel>() {
            @Override
            public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
                String status = response.body().getStatus();
                progressDialog.dismiss();

                if (status.equals("success")){
                    Toast.makeText(SponsorActivity.this, "Sponsor sukses di daftarkan", Toast.LENGTH_LONG).show();
                    Intent perbarui = new Intent(SponsorActivity.this, SponsorActivity.class);
                    startActivity(perbarui);
                    finish();
                }else {
                    Toast.makeText(SponsorActivity.this, "Maaf Coba lagi!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponseModel> call, Throwable t) {

                progressDialog.dismiss();
                Toast.makeText(SponsorActivity.this, "Connectivity Error", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);
        ButterKnife.bind(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerJenisSpons.setAdapter(adapter);

        ArrayAdapter<String> adapters = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemss);
        spinnerJenisEvent.setAdapter(adapters);
    }
}
