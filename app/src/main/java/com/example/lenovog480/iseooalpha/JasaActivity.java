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

public class JasaActivity extends AppCompatActivity {

    public ProgressDialog progressDialog;
    public final String URL = "your_api";
    String nama_jasa, harga_jasa, kontak_jasa, jenis_jasa, desk_jasa, untuk_event, pemilik_jasa;

    @OnClick(R.id.back_arrow) void balik(){
        finish();
    }

    @BindView(R.id.jasa_name)EditText namaJasa;
    @BindView(R.id.harga_jasa)EditText hargaJasa;
    @BindView(R.id.kontak_jasa)EditText kontakJasa;
    //@BindView(R.id.jenis_jasa)EditText jenisJasa;
    @BindView(R.id.spinnerJenisJasa)Spinner jenisJasa;
    @BindView(R.id.deskripsi_jasa)EditText deskJasa;
    //@BindView(R.id.jasa_jenisEvent)EditText jenisEvent;
    @BindView(R.id.spinnerJenisEvent)Spinner jenisEvent;
    @BindView(R.id.pemilik_jasa)EditText pemilikJasa;

    private String[] items = new String[]{"Tempat", "Perlengkapan"};
    private String[] itemss = new String[]{"All Event", "Musik", "Seminar", "Pameran", "Pagelaran"};
    int a = 1;
    int b = 2;
    int c = 3;
    int d = 4;
    int e = 5;

    @OnClick(R.id.submit_jasa)void submitJasa(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();

        nama_jasa = namaJasa.getText().toString();
        harga_jasa = hargaJasa.getText().toString();
        kontak_jasa = kontakJasa.getText().toString();
      //  jenis_jasa = jenisJasa.getText().toString();
        items[0] = String.valueOf(a);
        items[1] = String.valueOf(b);
        jenis_jasa = String.valueOf(jenisJasa.getSelectedItem());

        itemss[0] = String.valueOf(a);
        itemss[1] = String.valueOf(b);
        itemss[2] = String.valueOf(c);
        itemss[3] = String.valueOf(d);
        itemss[4] = String.valueOf(e);
        untuk_event = String.valueOf(jenisEvent.getSelectedItem());
        desk_jasa = deskJasa.getText().toString();
        //untuk_event = jenisEvent.getText().toString();
        pemilik_jasa = pemilikJasa.getText().toString();

        Retrofit acara = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        APIService api = acara.create(APIService.class);
        Call<ApiResponseModel> call = api.newJasa(nama_jasa, harga_jasa, kontak_jasa, jenis_jasa, desk_jasa, untuk_event, pemilik_jasa);
        call.enqueue(new Callback<ApiResponseModel>() {
            @Override
            public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
                String status = response.body().getStatus();
                progressDialog.dismiss();

                if (status.equals("success")){
                    Toast.makeText(JasaActivity.this, "Jasa sukses di daftarkan", Toast.LENGTH_LONG).show();
                    Intent perbarui = new Intent(JasaActivity.this, JasaActivity.class);
                    startActivity(perbarui);
                    finish();
                }else {
                    Toast.makeText(JasaActivity.this, "Maaf Coba lagi!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponseModel> call, Throwable t) {

                progressDialog.dismiss();
                Toast.makeText(JasaActivity.this, "Connectivity Error", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jasa);
        ButterKnife.bind(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        jenisJasa.setAdapter(adapter);

        ArrayAdapter<String> adapters = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemss);
        jenisEvent.setAdapter(adapters);
    }
}
