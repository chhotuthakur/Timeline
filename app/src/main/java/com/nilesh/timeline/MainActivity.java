package com.nilesh.timeline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText title,content;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.edt_title);
        content = findViewById(R.id.edt_content);
        add = findViewById(R.id.add_data);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

                String tit = title.getText().toString();
                String con = content.getText().toString();
                String id = tit;

                databaseReference.child("upsc").child(id).child("title").setValue(tit);
                databaseReference.child("upsc").child(id).child("content").setValue(con);
            }
        });
    }
}