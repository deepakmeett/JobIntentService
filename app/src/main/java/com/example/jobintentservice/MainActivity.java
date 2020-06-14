package com.example.jobintentservice;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        button = findViewById( R.id.buttonPanel );
        editText = findViewById( R.id.edit_query );
        
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                Intent serviceIntent = new Intent( MainActivity.this, ExampleJobIntentService.class );
                serviceIntent.putExtra( "inputExtra", text );
                ExampleJobIntentService.enqueueWork( MainActivity.this, serviceIntent );
            }
        } );
    }
}
