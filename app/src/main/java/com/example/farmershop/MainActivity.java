package com.example.farmershop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner itemSpinner;
    EditText priceEd;
    EditText quantityEd;
    Button buyButton;
    TextView totalTv;


    int quantity;
    int price;
    String selectedFert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemSpinner = findViewById(R.id.item_spinner);
        quantityEd = findViewById(R.id.quantity_ed);
        priceEd = findViewById(R.id.price_ed);
        buyButton = findViewById(R.id.buy_btn);
        if (buyButton != null) {
            buyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    purchaseProduct();
                }
            });
        }
        initializeItemSpinner();

    }



    private void initializeItemSpinner() {
        ArrayAdapter<CharSequence> itemAdapter = ArrayAdapter.createFromResource(this,
                R.array.item_array, R.layout.support_simple_spinner_dropdown_item);
        itemAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        itemSpinner.setAdapter(itemAdapter);
        itemSpinner.setOnItemSelectedListener(this);
        itemSpinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedFert = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void purchaseProduct() {
        quantity = Integer.parseInt(quantityEd.getText().toString());
        price = Integer.parseInt(priceEd.getText().toString());
//        int myTotal = (quantity*price);
//        totalTv.setText(myTotal);

        Log.d("MYFERTILIZER", selectedFert);

        saveToDataBase();

    }

    private void saveToDataBase() {

    }


}
