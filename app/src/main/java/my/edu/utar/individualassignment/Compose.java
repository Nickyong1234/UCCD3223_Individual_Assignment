package my.edu.utar.individualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;

public class Compose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        // declare atomic integer for Number, Operation, random, and correct
        AtomicInteger Number = new AtomicInteger();
        AtomicInteger Operation = new AtomicInteger();
        AtomicInteger random = new AtomicInteger();
        AtomicInteger correct = new AtomicInteger();

        // Random Number for Operation (Addition or Subtraction)
        random.set((int) (Math.random() * 2));
        if (random.get() == 0) {
            // Addition
            Operation.set(1);
            //Replace Operation text with "Addition"
            TextView OperationTitle = findViewById(R.id.OperationSym);
            OperationTitle.setText("+");
        }
        else {
            // Subtraction
            Operation.set(0);
            //Replace Operation text with "Subtraction"
            TextView OperationTitle = findViewById(R.id.OperationSym);
            OperationTitle.setText("-");
        }

        // Random Number for Question
        random.set((int) (Math.random() * 100));
        Number.set(random.get());
        //Replace QuestionNumber text with "Number"
        TextView QuestionNumber = findViewById(R.id.QuestionNumber);
        QuestionNumber.setText(String.valueOf(Number.get()));

        // Listener for Submit Button
        Button Submit = findViewById(R.id.SubmitButton);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Set Correct to 0
                correct.set(0);

                // Getter for Input1
                EditText input1 = findViewById(R.id.Input1);
                String input1String = input1.getText().toString();
                int Input1 = Integer.parseInt(input1String);

                // Getter for Input2
                EditText input2 = findViewById(R.id.Input2);
                String input2String = input2.getText().toString();
                int Input2 = Integer.parseInt(input2String);

                // Create an intent to start the compose activity
                if (Operation.get() == 1 /*Addition*/) {
                    if (Input1 + Input2 == Number.get()){
                        Toast.makeText(Compose.this, "Correct!", Toast.LENGTH_SHORT).show();
                        correct.set(1);
                    }
                    else {
                        Toast.makeText(Compose.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    if (Input1 - Input2 == Number.get()){
                        Toast.makeText(Compose.this, "Correct!", Toast.LENGTH_SHORT).show();
                        correct.set(1);
                    }
                    else {
                        Toast.makeText(Compose.this, "Wrong!", Toast.LENGTH_SHORT).show();
                    }
                }
                // Clear the input fields
                input1.setText("");
                input2.setText("");
                // if correct is 1, then randomize Operation and Number
                if (correct.get() == 1) {
                    // Random Number for Operation (Addition or Subtraction)
                    random.set((int) (Math.random() * 2));
                    if (random.get() == 0) {
                        // Addition
                        Operation.set(1);
                        //Replace Operation text with "Addition"
                        TextView OperationTitle = findViewById(R.id.OperationSym);
                        OperationTitle.setText("+");
                    } else {
                        // Subtraction
                        Operation.set(0);
                        //Replace Operation text with "Subtraction"
                        TextView OperationTitle = findViewById(R.id.OperationSym);
                        OperationTitle.setText("-");
                    }
                    // Random Number for Question
                    random.set((int) (Math.random() * 100));
                    Number.set(random.get());
                    //Replace QuestionNumber text with "Number"
                    TextView QuestionNumber = findViewById(R.id.QuestionNumber);
                    QuestionNumber.setText(String.valueOf(Number.get()));
                }
            }
        });

        // Get the Back button
        Button Back = findViewById(R.id.BackButton);
        // Create a button listener
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // End the activity
                finish();
            }
        });
    }
}