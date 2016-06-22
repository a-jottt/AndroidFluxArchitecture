package com.example.androidfluxarchitecture.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.androidfluxarchitecture.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.editTextLanguage)
    EditText editTextLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Click(R.id.buttonSearch)
    public void searchRepositories() {
        String language = editTextLanguage.getText().toString();
        if (!language.isEmpty()) {
            editTextLanguage.setText("");
            //action
        }
    }
}