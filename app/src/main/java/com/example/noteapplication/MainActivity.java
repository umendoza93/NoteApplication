package com.example.noteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnSave;
    EditText noteLine, noteContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        noteLine = findViewById(R.id.txtID);
        noteContent = findViewById(R.id.txtContent);

        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String line = noteLine.getText().toString();
                if (line.length() == 0) {
                    return;
                }
                String content = noteContent.getText().toString();
                Log.i("info", "Ths content of body is " + content);
                if (content.length() == 0) {
                    content = line;
                }
                else {
                    content = content + "\n" + line;
                    //content = "- " + content + "\n" + line;
                }

                SharedPreferences pref = getPreferences(0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("note1",content);
                editor.commit();
                noteLine.getText().clear();
                noteContent.setText(content);
            }
        });

//        btnLoad.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String id = noteID.getText().toString();
//                String content = "";
//                SharedPreferences pref = getPreferences(0);
//                if (pref.contains(id)) {
//                    content = pref.getString(id, "ID not available. Start new note.");
//                }
//                else {
//                    content = pref.getString(id,"Test");
//                }
//                noteContent.setText(content);
//            }
//        });

    }
}
