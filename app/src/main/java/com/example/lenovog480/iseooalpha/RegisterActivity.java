package com.example.lenovog480.iseooalpha;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
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

@RequiresApi(api = Build.VERSION_CODES.N)
public class RegisterActivity extends AppCompatActivity {

    String nama_lengkap, username,  email, password, no_telp;
    public ProgressDialog progress;
    public final String URL = "your_api";

    @BindView(R.id.fullname) EditText editTextFullname;
    @BindView(R.id.username) EditText editTextUsername;
    @BindView(R.id.email) EditText editTextEmail;
    @BindView(R.id.password) EditText editTextPassword;
    @BindView(R.id.phone) EditText editTextPhone;
    @OnClick(R.id.loginBtn) void login(){
        Intent pindah = new Intent(this, LoginActivity.class);
        startActivity(pindah);
        finish();
    }
    @OnClick(R.id.registerBtn) void regist(){

        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading.....");
        progress.show();

        nama_lengkap = editTextFullname.getText().toString();
        username = editTextUsername.getText().toString();
        email = editTextEmail.getText().toString();
        password = editTextPassword.getText().toString();
        no_telp = editTextPhone.getText().toString();

        Retrofit register = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        APIService API = register.create(APIService.class);
        Call<ApiResponseModel> call = API.regist(nama_lengkap, username, email, password, no_telp);
        call.enqueue(new Callback<ApiResponseModel>() {
            @Override
            public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
                //String value = response.body().getValue();
                //ApiResponseModel res = response.body();
               //String message = response.body().getMessage();
                String value = response.body().getStatus();
                progress.dismiss();

                if (value.equals("success")){
                    Toast.makeText(RegisterActivity.this,"Sukses Mendaftar", Toast.LENGTH_LONG).show();
                    Intent callback = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(callback);
                    finish();
                }else {
                    value.equals("fail");
                    Toast.makeText(RegisterActivity.this, "Gagal Mendaftar", Toast.LENGTH_LONG).show();
                    Intent callback = new Intent(RegisterActivity.this, RegisterActivity.class);
                    startActivity(callback);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<ApiResponseModel> call, Throwable t) {
                t.printStackTrace();
                progress.dismiss();
                Toast.makeText(RegisterActivity.this, "Connectivity Error", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }
}
