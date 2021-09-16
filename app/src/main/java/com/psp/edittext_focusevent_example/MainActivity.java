package com.psp.edittext_focusevent_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener{

    EditText edtOne,edtTwo,edtThree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtOne = findViewById(R.id.edtOne);
        edtTwo = findViewById(R.id.edtTwo);
        edtThree = findViewById(R.id.edtThree);
    }

    @Override
    protected void onPause() {
        super.onPause();
        setOnFocusChangeListener(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setOnFocusChangeListener(true);
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        int id = v.getId();

        if(id == R.id.edtOne) {
            if(hasFocus) {
                logMsg("Edittext one hasFocus true");
            } else {
                logMsg("Edittext one hasFocus false");
            }
        }
        else if (id == R.id.edtTwo) {
            if(hasFocus) {
                logMsg("Edittext two hasFocus true");
            } else {
                logMsg("Edittext two hasFocus false");
            }
        }
        else if(id == R.id.edtThree) {
            if(hasFocus) {
                logMsg("Edittext three hasFocus true");
            } else {
                logMsg("Edittext three hasFocus false");
            }
        }
    }

    private void setOnFocusChangeListener(boolean attach) {
        if(attach) {
            edtOne.setOnFocusChangeListener(this);
            edtTwo.setOnFocusChangeListener(this);
            edtThree.setOnFocusChangeListener(this);
        } else {
            edtOne.setOnFocusChangeListener(null);
            edtTwo.setOnFocusChangeListener(null);
            edtThree.setOnFocusChangeListener(null);
        }
    }

    private void logMsg(String msg) {
        Log.d("FocusChangeExample",msg);
    }
}