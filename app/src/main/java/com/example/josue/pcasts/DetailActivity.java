package com.example.josue.pcasts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    Toolbar toolbar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar2 = (Toolbar) findViewById(R.id.toolbar);
        toolbar2.setTitle("Conta-me Tudo");
        setSupportActionBar(toolbar2);

        Intent intent = getIntent();
        String txtTit = intent.getStringExtra("title");
        String txtPD = intent.getStringExtra("pubDate");
        String txtCont = intent.getStringExtra("content");

        TextView txtTitle, txtPubDate, txtContent;
        txtTitle = (TextView) findViewById(R.id.txtTitleD);
        txtPubDate = (TextView) findViewById(R.id.txtPubDateD);
        txtContent = (TextView) findViewById(R.id.txtContentD);
        txtTitle.setText(txtTit.toString());
        txtPubDate.setText(txtPD.toString());
        txtContent.setText(txtCont.toString());
    }

    public void goBack() {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_back)
            goBack();
        return true;
    }
}




