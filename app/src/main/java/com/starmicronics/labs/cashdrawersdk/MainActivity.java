package com.starmicronics.labs.cashdrawersdk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.starmicronics.labs.CashDrawer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    CashDrawer drawer = new CashDrawer(); // instantiate generic CashDrawer object
    List<CashDrawer> drawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void searchForDrawers(View view) {

        drawerList = CashDrawer.discover(this);
        ArrayList<Integer> portNumbers = new ArrayList<>();

        if (drawerList.isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("No drawers found.");
            builder.show();
        }
        else {
            Toast.makeText(this, drawerList.size() + " drawers found.", Toast.LENGTH_LONG).show();
            for (CashDrawer drawer: drawerList ) { portNumbers.add(drawer.port); }

            Spinner spinner = findViewById(R.id.spinner);
            ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, portNumbers);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(arrayAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    drawer.port = (int)parent.getItemAtPosition(position);
                    Toast.makeText(parent.getContext(), "Selected Port: " + drawer.port, Toast.LENGTH_LONG).show();
                }
                @Override
                public void onNothingSelected(AdapterView <?> parent) {

                }
            });
        }
    }

    public void getStatus(View view) {
        String getStatus = drawer.status(drawer.port, this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Drawer Number: " + drawer.port + "\nStatus: " + getStatus)
                .setPositiveButton("OK", (dialog, id) -> dialog.dismiss());
        builder.create();
        builder.show();
    }

    public void popCashDrawer(View view) {

        Boolean result = drawer.open(drawer.port, this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Pop Drawer: " + result)
                .setPositiveButton("OK", (dialog, id) -> dialog.dismiss());
        builder.create();
        builder.show();
    }
}

