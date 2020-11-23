package com.example.lenovog480.iseooalpha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.lenovog480.iseooalpha.dialog.DiaologOrderPerkapActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailPerkapActivity extends AppCompatActivity {

    @OnClick(R.id.back_arrow)void balik(){
        finish();
    }

    @BindView(R.id.txtNamaSponsor)TextView namaSponsor;
    @BindView(R.id.txtHargaSponsor)TextView hargaSponsor;
    @BindView(R.id.txtKontakSponsor)TextView kontakSponsor;
    @BindView(R.id.txtDeskripsiSponsor)TextView deskSponsor;
    @BindView(R.id.txtJenisEvent)TextView jenisEvent;
    @BindView(R.id.txtPemilik)TextView pemilik;
    @BindView(R.id.txtIdJasa)TextView id;

    @OnClick(R.id.BtnRequest)void order(){
        Intent pindah = new Intent(this, DiaologOrderPerkapActivity.class);
        startActivity(pindah);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_perkap);
        ButterKnife.bind(this);

        String nama = getIntent().getExtras().getString("namaJasa");
        String jenis = getIntent().getExtras().getString("kontakJasa");
        String kontak = getIntent().getExtras().getString("hargaJasa");
        String desk = getIntent().getExtras().getString("deskripsiJasa");
        String jenisE = getIntent().getExtras().getString("jenisEvent");
        String pemilikS = getIntent().getExtras().getString("pemilikJasa");
        String ids = getIntent().getExtras().getString("id_jasa");

        namaSponsor.setText(nama);
        hargaSponsor.setText(kontak);
        kontakSponsor.setText(jenis);
        deskSponsor.setText(desk);
        jenisEvent.setText(jenisE);
        pemilik.setText(pemilikS);
        id.setText(ids);
    }
}
