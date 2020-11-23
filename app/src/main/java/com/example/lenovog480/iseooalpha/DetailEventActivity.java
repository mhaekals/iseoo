package com.example.lenovog480.iseooalpha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionMenu;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailEventActivity extends AppCompatActivity {

   // FloatingActionMenu materialDesignFAM;
    //FloatingActionButton floatingbuttonSponsor, floatingbuttonJasa;

    @OnClick(R.id.back_arrow)void balik(){
        finish();
    }

    @BindView(R.id.material_design_android_floating_action_menu)FloatingActionMenu materialDesignFAM;
    @BindView(R.id.detailIdEvent)TextView id;
    @BindView(R.id.detailNamaEvent)TextView nama;
    @BindView(R.id.detailJenisEvent)TextView jenis;
    @BindView(R.id.detailCreator)TextView creator;
    @BindView(R.id.detailDeskripsiEvent)TextView desk;
    @BindView(R.id.detailTgglEvent)TextView tggl;
    @BindView(R.id.detailStatusEvent)TextView status;

    @OnClick(R.id.floating_button_sponsor)void sponsor(){
        Intent pindahSponsor = new Intent(this, SearchSponsorActivity.class);
        startActivity(pindahSponsor);
        finish();
    }

    @OnClick(R.id.floating_button_jasa)void jasa(){
        Intent pindahJasa = new Intent(this, SearchTempatActivity.class);
        startActivity(pindahJasa);
        finish();
    }

    @OnClick(R.id.floating_button_jasaPerlengkapan)void perlengkapan(){
        Intent pindahJasa = new Intent(this, SearchPerlengkapanActivity.class);
        startActivity(pindahJasa);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);
        ButterKnife.bind(this);

        String idAcara = getIntent().getExtras().getString("idEvent");
        String namaAcara = getIntent().getExtras().getString("namaEvent");
        String jenisAcara = getIntent().getExtras().getString("jenisEvent");
        String creatorAcara = getIntent().getExtras().getString("creator");
        String deskAcara = getIntent().getExtras().getString("deskripsiEvent");
        String tgglAcara = getIntent().getExtras().getString("tanggalEvent");
        String statusAcara = getIntent().getExtras().getString("statusEvent");

        id.setText(idAcara);
        nama.setText(namaAcara);
        jenis.setText(jenisAcara);
        creator.setText(creatorAcara);
        desk.setText(deskAcara);
        tggl.setText(tgglAcara);
        status.setText(statusAcara);


    }
}
