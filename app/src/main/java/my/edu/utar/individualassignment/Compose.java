package my.edu.utar.individualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Compose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        // declare a new int variable
        int Number;
        // declare a new int variable for Operation
        int Operation;
        // Random Number for Operation (Addition or Subtraction)
        int random = (int) (Math.random() * 2);
        if (random == 0) {
            // Addition
            Operation = 1;
            //Replace Operation text with "Addition"
            TextView OperationTitle = findViewById(R.id.OperationSym);
            OperationTitle.setText("+");
        }
        else {
            // Subtraction
            Operation = 0;
            //Replace Operation text with "Subtraction"
            TextView OperationTitle = findViewById(R.id.OperationSym);
            OperationTitle.setText("-");
        }
        // Random Number for Question
        random = (int) (Math.random() * 100);
        Number = random;
        //Replace QuestionNumber text with "Number"
        TextView QuestionNumber = findViewById(R.id.QuestionNumber);
        QuestionNumber.setText(String.valueOf(Number));

        // Listener for Submit Button
        Button Submit = findViewById(R.id.SubmitButton);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Getter for Input1
                EditText input1 = findViewById(R.id.Input1);
                String input1String = input1.getText().toString();
                int Input1 = Integer.parseInt(input1String);

                // Getter for Input2
                EditText input2 = findViewById(R.id.Input2);
                String input2String = input2.getText().toString();
                int Input2 = Integer.parseInt(input2String);

                // Create an intent to start the compose activity
                if (Operation == 1 /*Addition*/) {
                    if (Input1 + Input2 == Number){
                        Toast.makeText(Compose.this, "Correct!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Compose.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    if (Input1 - Input2 == Number){
                        Toast.makeText(Compose.this, "Correct!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Compose.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // Get the Back button
        Button Back = findViewById(R.id.BackButton);
        // Create a button listener
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to start the main activity
                finish();
            }
        });
    }
}