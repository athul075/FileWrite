package com.zco.filewriteapp;


import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Sample class to write file
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnWtite = (Button) findViewById(R.id.button_Write);

        btnWtite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                writeToFile();
            }
        });
    }

    private void writeToFile() {

        try {
            File myFile = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(),"ABCD.txt");

            boolean fExist = myFile.exists();
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile, true);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);

            if(fExist && !myFile.isDirectory()) {

                myOutWriter.append("\n");
                myOutWriter.append("New text");
            }

            myOutWriter.close();
            fOut.close();
        }
        catch (Exception e) {
            Toast.makeText(this, "ERROR " + e.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("ERROR", "Could not create file", e);
        }
    }
}
