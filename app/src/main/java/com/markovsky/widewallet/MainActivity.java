package com.markovsky.widewallet;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText productName;
    EditText productPrice;
    Button   btnAdd;
    RecyclerView itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productName = findViewById(R.id.etProductName);
        productPrice = findViewById(R.id.etProductPrice);
        btnAdd = findViewById(R.id.btnAdd);

        itemsList = findViewById(R.id.rvItemList);

        final SpendingDBHelper spendingDBHelper = new SpendingDBHelper(itemsList.getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        itemsList.setLayoutManager(linearLayoutManager);
        final ListAdapter listAdapter = new ListAdapter(spendingDBHelper.getReadableDatabase());
        itemsList.setAdapter(listAdapter);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout createField = findViewById(R.id.LLforCreatedViews);

                if (productName.getText().toString().equals("") && productPrice.getText().toString().equals(""))
                    Toast.makeText(createField.getContext(), R.string.errorEmptyString, Toast.LENGTH_LONG).show();
                else
                {
                    // Добавление новой записи в БД
                    // Обновление RecyclerView
                    SpendingDBHelper.insertLine(spendingDBHelper.getWritableDatabase(), null, productName.getText().toString(), Integer.parseInt(productPrice.getText().toString()));
                    listAdapter.notifyDataSetChanged();
                }
            }
        });

    }


}
