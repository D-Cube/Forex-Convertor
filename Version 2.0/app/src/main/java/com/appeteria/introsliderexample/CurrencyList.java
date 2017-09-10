package com.appeteria.introsliderexample;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class CurrencyList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_list);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.currencies));
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                new AlertDialog.Builder(CurrencyList.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("STOCK PRICE UNAVAILABLE")
                        .setMessage("SERVER IS CURRENTLY UNDER MAINTENANCE")
                        .setPositiveButton("ERROR 404" , new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(CurrencyList.this , "REFRESHED" , Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("CLOSE" , null)
                        .show();

                return false;
            }
        });
    }
}
