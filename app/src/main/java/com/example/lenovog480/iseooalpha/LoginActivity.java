package com.example.lenovog480.iseooalpha;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovog480.iseooalpha.adapter.SessionManager;
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

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private ProgressDialog pd;
    private SessionManager sm;
    public final String URL = "your_api";

    @BindView(R.id.usernameLogin)EditText username;
    @BindView(R.id.passwordLogin)EditText password;

    @OnClick(R.id.lupaPassword)void reset(){

    }
    @OnClick(R.id.Btnregister)void regist(){
        Intent pindahRegist = new Intent(this, RegisterActivity.class);
        startActivity(pindahRegist);
        finish();
    }

    @OnClick(R.id.Btnlogin)void login(){
        pd = new ProgressDialog(this);
        pd.setMessage("loading...");
        pd.show();
        sm = new SessionManager(LoginActivity.this);

        Retrofit Login = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        APIService API = Login.create(APIService.class);
        Call<ApiResponseModel> login = API.login(username.getText().toString(),password.getText().toString());
        login.enqueue(new Callback<ApiResponseModel>() {
            @Override
            public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
                pd.dismiss();
                //Log.d(TAG, "response : " + response.toString());
                //ApiResponseModel res = response.body();
                //List<UserModel> user = response.body().getResult();
                //String value = response.body().getValue();
                String value = response.body().getStatus();
                if(value.equals("success")){
                    //sm.storeLogin(user.get(0).getUsername(), user.get(0).getNama_lengkap());

                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();;
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    //intent.putExtra("username", user.get(0).getUsername());
                    //intent.putExtra("nama_lengkap", user.get(0).getNama_lengkap());
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "Username/Password Invalid", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponseModel> call, Throwable t) {
                pd.dismiss();
                //Log.d(TAG, "error : " + t.getMessage());
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
}
