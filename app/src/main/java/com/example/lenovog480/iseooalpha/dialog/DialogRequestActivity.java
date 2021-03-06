package com.example.lenovog480.iseooalpha.dialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovog480.iseooalpha.R;
import com.example.lenovog480.iseooalpha.ViewEventActivity;
import com.example.lenovog480.iseooalpha.api.APIService;
import com.example.lenovog480.iseooalpha.model.ApiResponseModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DialogRequestActivity extends AppCompatActivity {

    String lamaEvent, tgglMulai, id, sponsor;
    public ProgressDialog progressDialog;
    public final String URL = "your_api_url";

    final Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };

    @OnClick(R.id.back_arrow)void balik(){
        finish();
    }
    @BindView(R.id.lama)EditText lamaPemakaian;
    @BindView(R.id.mulai)EditText mulaiEvent;
    @BindView(R.id.id_event)EditText id_event;
    @BindView(R.id.id_sponsor)EditText id_sponsor;
    @OnClick(R.id.mulai)void mulai(){
        new DatePickerDialog(this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }


    private void updateLabel() {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        mulaiEvent.setText(sdf.format(myCalendar.getTime()));

    }

    @OnClick(R.id.submit_request)void submit(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();

        id = id_event.getText().toString();
        sponsor = id_sponsor.getText().toString();
        lamaEvent = lamaPemakaian.getText().toString();
        tgglMulai = mulaiEvent.getText().toString();
        Retrofit acara = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        APIService api = acara.create(APIService.class);
        Call<ApiResponseModel>call = api.request(lamaEvent, tgglMulai, id, sponsor);
        call.enqueue(new Callback<ApiResponseModel>() {
            @Override
            public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
                String value = response.body().getStatus();
                progressDialog.dismiss();
                if (value.equals("success")){
                    Toast.makeText(DialogRequestActivity.this, "Sukses request sponsor", Toast.LENGTH_LONG).show();
                    Intent perbarui = new Intent(DialogRequestActivity.this, ViewEventActivity.class);
                    startActivity(perbarui);
                    finish();
                }else {
                    Toast.makeText(DialogRequestActivity.this, "Maaf Coba lagi!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponseModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(DialogRequestActivity.this, "Connectivity Error", Toast.LENGTH_LONG).show();
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_request);
        ButterKnife.bind(this);
    }
}
