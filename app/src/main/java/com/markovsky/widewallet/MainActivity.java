package com.markovsky.widewallet;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productName = findViewById(R.id.etProductName);
        productPrice = findViewById(R.id.etProductPrice);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout createField = findViewById(R.id.LLforCreatedViews);

                if (productName.getText().toString().equals("") && productPrice.getText().toString().equals(""))
                    Toast.makeText(createField.getContext(), R.string.errorEmptyString, Toast.LENGTH_LONG).show();
                else
                {
                    // горизонтальный LinearLayout для каждой записи(строки)
                    LinearLayout createRow = new LinearLayout(createField.getContext());
                    createRow.setOrientation(LinearLayout.HORIZONTAL);
                    LinearLayout.LayoutParams newRowParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    createRow.setLayoutParams(newRowParams);

                    // Создание новой записи
                    TextView newProductName = new TextView(createField.getContext());
                    LinearLayout.LayoutParams newProductNameParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    newProductNameParams.weight = 5;

                    TextView newProductPrice = new TextView(createField.getContext());
                    LinearLayout.LayoutParams newProductPriceParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    newProductPriceParams.weight = 2;

                    newProductName.setText(productName.getText().toString());
                    newProductPrice.setText(productPrice.getText().toString());

                    // Отображение новой записи
                    createRow.addView(newProductName, newProductNameParams);
                    createRow.addView(newProductPrice, newProductPriceParams);

                    createField.addView(createRow, newRowParams);

                    // Обнуление полей ввода
                    productName.setText("");
                    productPrice.setText("");
                }
            }
        });

    }


}
