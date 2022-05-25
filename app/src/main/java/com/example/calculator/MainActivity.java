package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private static final String FILE_NAME = "AK7.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void saveFile(View view)
    {
        FileOutputStream fos = null;
        EditText n1 = (EditText) findViewById(R.id.N1);
        EditText n2 = (EditText) findViewById(R.id.N2);
        int num1 = Integer.parseInt(n1.getText().toString());
        int num2 = Integer.parseInt(n2.getText().toString());
        try
        {
            fos = openFileOutput("AK7.txt", MODE_APPEND);
            fos.write(("Sum : " + (num1 + num2) + "\n").getBytes());
            fos.write(("Diff : " + (num1 - num2) + "\n").getBytes());
            fos.write(("Prod : " + (num1 * num2) + "\n").getBytes());
            fos.write(("Div : " + (num1 / num2) + "\n").getBytes());
            n1.setText("num1");
            n2.setText("num2");
            Toast.makeText(this, "Saved to " + getFilesDir() + "/AK7.txt", Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
