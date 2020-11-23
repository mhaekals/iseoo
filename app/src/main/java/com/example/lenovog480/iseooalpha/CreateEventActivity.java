package com.example.lenovog480.iseooalpha;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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


@RequiresApi(api = Build.VERSION_CODES.N)
public class CreateEventActivity extends AppCompatActivity {

    String nama_event, jenis_event, creator_event, desk_event; String tanggal_event, values;
   // int values;
    //Date tanggal_event;
    public ProgressDialog progressDialog;
    public final String URL = "your_api";
    @BindView(R.id.toolbar_balik)Toolbar toolbar;
    @OnClick(R.id.back_arrow)void back(){
        finish();
    }

    @BindView(R.id.event_name)EditText namaEvent;
   // @BindView(R.id.event_type)EditText jenisEvent;
    @BindView(R.id.creator_name)EditText creatorEvent;
    @BindView(R.id.event_desc)EditText deskEvent;
    @BindView(R.id.event_date)EditText tanggalEvent;
    @BindView(R.id.spinnerJenisEvent)Spinner spinnerJenisE;

    //private List<CharSequence> items;
   //private String[] items = new String[]{"1", "2", "3", "4", "5"};
   private String[] items = new String[]{"All Event", "Musik", "Seminar", "Pameran", "Pagelaran"};
    //private Integer[] items = new Integer[]{1, 2, 3, 4, 5};
  // String a = "1";
    //String b = "2";
    //String c = "3";
    //String d = "4";
    //String e = "5";
    int a = 1;
    int b = 2;
    int c = 3;
    int d = 4;
    int e = 5;
    //private String[] items = new String[]{"1", "2", "3", "4", "5"};
    //int[] myvalue = new int[items.length];

    //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);



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

    @OnClick(R.id.event_date) void ultah(){
        new DatePickerDialog(this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }
    private void updateLabel() {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        tanggalEvent.setText(sdf.format(myCalendar.getTime()));

    }

    @OnClick(R.id.submit_event)void submitAcara(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading.....");
        progressDialog.show();

        nama_event = namaEvent.getText().toString();
        //jenis_event = jenisEvent.getText().toString();
        //int [] value = new int[items.length];
        //values = String.valueOf(spinnerJenisE.getSelectedItem());
        items[0] = String.valueOf(a);
        items[1] = String.valueOf(b);
        items[2] = String.valueOf(c);
        items[3] = String.valueOf(d);
        items[4] = String.valueOf(e);

        values = String.valueOf(spinnerJenisE.getSelectedItem());

        //spinnerJenisE.getSelectedItemId();
        //String[] items = new String[]{"All Event", "Musik", "Seminar", "Pameran", "Pagelaran"};
        creator_event = creatorEvent.getText().toString();
        desk_event = deskEvent.getText().toString();
        tanggal_event = tanggalEvent.getText().toString();



        Retrofit acara = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        APIService api = acara.create(APIService.class);
        Call<ApiResponseModel> call = api.newEvent(nama_event, values, creator_event, desk_event, tanggal_event);
        call.enqueue(new Callback<ApiResponseModel>() {
            @Override
            public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
                //String value = response.body().getValue();
                //String message = response.body().getMessage();
                String value = response.body().getStatus();
                progressDialog.dismiss();

                if (value.equals("success")){
                    Toast.makeText(CreateEventActivity.this, "Event sukses di daftarkan", Toast.LENGTH_LONG).show();
                    Intent perbarui = new Intent(CreateEventActivity.this, CreateEventActivity.class);
                    startActivity(perbarui);
                    finish();
                }else {
                    Toast.makeText(CreateEventActivity.this, "Maaf Coba lagi!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponseModel> call, Throwable t) {
                t.printStackTrace();
                progressDialog.dismiss();
                Toast.makeText(CreateEventActivity.this, "Connectivity Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        ButterKnife.bind(this);
       // ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerJenisE.setAdapter(adapter);

    }
}
