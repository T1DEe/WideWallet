package com.markovsky.widewallet;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText etProductName;
    EditText etProductPrice;
    Button   btnAdd;
    RecyclerView rvSpendsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etProductName = findViewById(R.id.etProductName);
        etProductPrice = findViewById(R.id.etProductPrice);
        btnAdd = findViewById(R.id.btnAdd);

        rvSpendsList = findViewById(R.id.rvSpendsList);

        final SpendsDBHelper spendsDBHelper = new SpendsDBHelper(rvSpendsList.getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvSpendsList.setLayoutManager(linearLayoutManager);
        final rvSpendsAdapter listAdapter = new rvSpendsAdapter(spendsDBHelper.getReadableDatabase());
        rvSpendsList.setAdapter(listAdapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout mainLeanerLayout = findViewById(R.id.mainLeanerLayout);

                if (etProductName.getText().toString().equals("") && etProductPrice.getText().toString().equals(""))
                    Toast.makeText(mainLeanerLayout.getContext(), R.string.errorEmptyString, Toast.LENGTH_LONG).show();
                else
                {
                    // Добавление новой записи в БД
                    // Обновление RecyclerView
                    SpendsDBHelper.insertSpendInDB(spendsDBHelper.getWritableDatabase(), null, etProductName.getText().toString(), Integer.parseInt(etProductPrice.getText().toString()));
                    listAdapter.notifyDataSetChanged();
                }
            }
        });

    }


}
