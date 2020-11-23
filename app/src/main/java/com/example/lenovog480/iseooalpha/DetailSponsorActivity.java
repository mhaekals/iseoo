package com.example.lenovog480.iseooalpha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.lenovog480.iseooalpha.dialog.DialogRequestActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailSponsorActivity extends AppCompatActivity {

    //private Context mContext;

    @OnClick(R.id.back_arrow)void balik(){
        finish();
    }

    @BindView(R.id.txtNamaSponsor)TextView namaSponsor;
    @BindView(R.id.txtKontakSponsor)TextView kontakSponsor;
    @BindView(R.id.txtJenisSponsor)TextView jenisSponsor;
    @BindView(R.id.txtDeskripsiSponsor)TextView deskSponsor;
    @BindView(R.id.txtJenisEvent)TextView jenisEvent;
    @BindView(R.id.txtPemilik)TextView pemilik;
    @BindView(R.id.txtIdSponsor)TextView idSpon;

    @OnClick(R.id.BtnRequest)void request(){


        //LayoutInflater.from(this).inflate(R.layout.activity_dialog_request, null);
        //AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setView(R.layout.activity_dialog_request);
        //AlertDialog alert = builder.create();
        //alert.show();

        Intent pindah = new Intent(this, DialogRequestActivity.class);
        //pindah.putExtra("namaSponsor", namaSponsor);

        startActivity(pindah);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sponsor);
        ButterKnife.bind(this);

        String nama = getIntent().getExtras().getString("namaSponsor");
        String kontak = getIntent().getExtras().getString("kontakSponsor");
        String jenis = getIntent().getExtras().getString("jenisSponsor");
        String desk = getIntent().getExtras().getString("deskSponsor");
        String jenisE = getIntent().getExtras().getString("jenisEvent");
        String pemilikS = getIntent().getExtras().getString("pemilikSponsor");
        String id = getIntent().getExtras().getString("idSponsor");

        namaSponsor.setText(nama);
        kontakSponsor.setText(kontak);
        jenisSponsor.setText(jenis);
        deskSponsor.setText(desk);
        jenisEvent.setText(jenisE);
        pemilik.setText(pemilikS);
        idSpon.setText(id);





    }
}
