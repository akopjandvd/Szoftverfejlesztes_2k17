package com.jelenleti.foodadviser;

import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Jenni on 2017. 12. 12..
 */

public class Pop extends Activity{
    Button btnAdd,but;
    EditText editNev, editRecept,editHozzavalok;


    @Override
    protected void onCreate(Bundle saveInstance)
    {
        setContentView(R.layout.popup1);
        super.onCreate(saveInstance);

        but = (Button) findViewById(R.id.button);

        btnAdd = (Button) findViewById(R.id.button_add);


        editNev = (EditText) findViewById(R.id.editText_nev);
        editRecept = (EditText) findViewById(R.id.editText_recept);
        editHozzavalok = (EditText) findViewById(R.id.editText_hozzavalo);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.8),(int)(height*.6));
        AddData();
        but();

    }

    public void AddData() {
        btnAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = MainActivity.myDb.insertData(editNev.getText().toString(), editRecept.getText().toString(), editHozzavalok.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(Pop.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Pop.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void but() {
        but.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = MainActivity.myDb.updateData(editNev.getText().toString(), editNev.getText().toString(), editRecept.getText().toString(), editHozzavalok.getText().toString());
                        if (isUpdate == true)
                            Toast.makeText(Pop.this, "Data Update", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Pop.this, "Data not Updated", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}
