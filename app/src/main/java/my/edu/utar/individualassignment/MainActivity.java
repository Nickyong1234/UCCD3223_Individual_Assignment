package my.edu.utar.individualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Get the button
        Button bcompare = (Button) findViewById(R.id.bcompare);
        // Create a button listener
        bcompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start the compare activity
                Intent intent = new Intent(MainActivity.this, Compare.class);
                // Start the activity
                startActivity(intent);
            }
        });

        // Get the button
        Button border = (Button) findViewById(R.id.border);
        // Create a button listener
        border.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start the order activity
                Intent intent = new Intent(MainActivity.this, Order.class);
                // Start the activity
                startActivity(intent);
            }
        });

        // Get the button
        Button bcompose = (Button) findViewById(R.id.bcompose);
        // Create a button listener
        bcompose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start the compose activity
                Intent intent = new Intent(MainActivity.this, Compose.class);
                // Start the activity
                startActivity(intent);
            }
        });
    }
}