package com.muhamadarief.bekup5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    //int number;
    private final double price = 20;
    private Button btnTambah, btnKurang, btnOrder;
    private TextView txtJumlah, txtHarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHarga = (TextView) findViewById(R.id.txtHarga);
        txtJumlah = (TextView) findViewById(R.id.txtJumlah);
        btnTambah = (Button) findViewById(R.id.btnTambah);
        btnKurang = (Button) findViewById(R.id.btnKurang);
        btnOrder = (Button) findViewById(R.id.btnOrder);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            display(1);
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display(-1);
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView hasilOrder = (TextView)findViewById(R.id.hasilOrder);
                Toast.makeText(MainActivity.this, "Pesanan anda "+ txtJumlah.getText() + " dengan total harga "+txtHarga.getText()+"", Toast.LENGTH_LONG).show();
            }
        });


    }

    public void display( int number){
        txtJumlah = (TextView) findViewById(R.id.txtJumlah);
        Integer jumlah = Integer.parseInt(String.valueOf(txtJumlah.getText()));
        number = number + jumlah;
        if (number < 1){ number = 0;}
        txtJumlah.setText(""+number);

        Double totalharga = number*price;
        txtHarga.setText("" + NumberFormat.getCurrencyInstance().format(totalharga));


    }


}
