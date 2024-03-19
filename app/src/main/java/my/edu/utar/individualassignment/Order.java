package my.edu.utar.individualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;

public class Order extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Declare a new AtomicInteger variable
        AtomicInteger Order = new AtomicInteger();
        // Random either Ascending or Descending
        AtomicInteger random = new AtomicInteger((int) (Math.random() * 2));
        if (random.get() == 0) {
            // Ascending
            Order.set(1);
            //Replace OrderTitle text with "Ascending"
            TextView OrderTitle = findViewById(R.id.OrderQuestion);
            OrderTitle.setText(R.string.please_select_the_numbers_in_ascending_order);
        }
        else {
            // Descending
            Order.set(0);
            //Replace OrderTitle text with "Descending"
            TextView OrderTitle = findViewById(R.id.OrderQuestion);
            OrderTitle.setText(R.string.please_select_the_numbers_in_descending_order);
        }

        // Generate 5 random numbers as the options
        AtomicInteger randomnum1 = new AtomicInteger((int) (Math.random() * 100));
        AtomicInteger randomnum2 = new AtomicInteger((int) (Math.random() * 100));
        AtomicInteger randomnum3 = new AtomicInteger((int) (Math.random() * 100));
        AtomicInteger randomnum4 = new AtomicInteger((int) (Math.random() * 100));
        AtomicInteger randomnum5 = new AtomicInteger((int) (Math.random() * 100));

        // Declare 5 Selectednum AtomicInteger variables
        AtomicInteger SNum1 = new AtomicInteger();
        AtomicInteger SNum2 = new AtomicInteger();
        AtomicInteger SNum3 = new AtomicInteger();
        AtomicInteger SNum4 = new AtomicInteger();
        AtomicInteger SNum5 = new AtomicInteger();

        // Set the 5 random numbers into the Num buttons
        Button num1 = findViewById(R.id.Num1);
        Button num2 = findViewById(R.id.Num2);
        Button num3 = findViewById(R.id.Num3);
        Button num4 = findViewById(R.id.Num4);
        Button num5 = findViewById(R.id.Num5);
        num1.setText(String.valueOf(randomnum1));
        num2.setText(String.valueOf(randomnum2));
        num3.setText(String.valueOf(randomnum3));
        num4.setText(String.valueOf(randomnum4));
        num5.setText(String.valueOf(randomnum5));

        // check if theres duplicates and zero
        if (randomnum1.get() == randomnum2.get() || randomnum1.get() == randomnum3.get() || randomnum1.get() == randomnum4.get() || randomnum1.get() == randomnum5.get() || randomnum2.get() == randomnum3.get() || randomnum2.get() == randomnum4.get() || randomnum2.get() == randomnum5.get() || randomnum3.get() == randomnum4.get() || randomnum3.get() == randomnum5.get() || randomnum4.get() == randomnum5.get() || randomnum1.get() == 0 || randomnum2.get() == 0 || randomnum3.get() == 0 || randomnum4.get() == 0 || randomnum5.get() == 0){
            generateRandomNumbers(randomnum1, randomnum2, randomnum3, randomnum4, randomnum5);
        }

        // Get the SelectedNum buttons
        Button SelectedNum1 = findViewById(R.id.Selectednum1);
        Button SelectedNum2 = findViewById(R.id.Selectednum2);
        Button SelectedNum3 = findViewById(R.id.Selectednum3);
        Button SelectedNum4 = findViewById(R.id.Selectednum4);
        Button SelectedNum5 = findViewById(R.id.Selectednum5);

        // When clicked on Num buttons, move the value to the SelectedNum button
        num1.setOnClickListener(view -> setNumber(SNum1, SNum2, SNum3, SNum4, SNum5, randomnum1, SelectedNum1, SelectedNum2, SelectedNum3, SelectedNum4, SelectedNum5));
        num2.setOnClickListener(view -> setNumber(SNum1, SNum2, SNum3, SNum4, SNum5, randomnum2, SelectedNum1, SelectedNum2, SelectedNum3, SelectedNum4, SelectedNum5));
        num3.setOnClickListener(view -> setNumber(SNum1, SNum2, SNum3, SNum4, SNum5, randomnum3, SelectedNum1, SelectedNum2, SelectedNum3, SelectedNum4, SelectedNum5));
        num4.setOnClickListener(view -> setNumber(SNum1, SNum2, SNum3, SNum4, SNum5, randomnum4, SelectedNum1, SelectedNum2, SelectedNum3, SelectedNum4, SelectedNum5));
        num5.setOnClickListener(view -> setNumber(SNum1, SNum2, SNum3, SNum4, SNum5, randomnum5, SelectedNum1, SelectedNum2, SelectedNum3, SelectedNum4, SelectedNum5));

        // when clicked on SelectedNum buttons, remove the number
        SelectedNum1.setOnClickListener(view -> {
            // Set the value to 0
            SNum1.set(0);
            // Set the text to the SelectedNum button
            SelectedNum1.setText(R.string.NumPlaceholder);
        });
        SelectedNum2.setOnClickListener(view -> {
            // Set the value to 0
            SNum2.set(0);
            // Set the text to the SelectedNum button
            SelectedNum2.setText(R.string.NumPlaceholder);
        });
        SelectedNum3.setOnClickListener(view -> {
            // Set the value to 0
            SNum3.set(0);
            // Set the text to the SelectedNum button
            SelectedNum3.setText(R.string.NumPlaceholder);
        });
        SelectedNum4.setOnClickListener(view -> {
            // Set the value to 0
            SNum4.set(0);
            // Set the text to the SelectedNum button
            SelectedNum4.setText(R.string.NumPlaceholder);
        });
        SelectedNum5.setOnClickListener(view -> {
            // Set the value to 0
            SNum5.set(0);
            // Set the text to the SelectedNum button
            SelectedNum5.setText(R.string.NumPlaceholder);
        });

        // Get the Submit button
        Button Submit = findViewById(R.id.SubmitButton);
        // Create a button listener
        Submit.setOnClickListener(view -> {
            // Create correct variable = 0
            int correct = 0;
            // Create an intent to start the order activity
            if (Order.get() == 1 /*Ascending*/) {
                if (SNum1.get() < SNum2.get() && SNum2.get() < SNum3.get() && SNum3.get() < SNum4.get() && SNum4.get() < SNum5.get()){
                    // To be replaced with another activity (Correct View)
                    Toast.makeText(Order.this, "Correct!", Toast.LENGTH_SHORT).show();
                    // Set correct to 1
                    correct = 1;
                }
                else {
                    // To be replaced with another activity (Incorrect View)
                    Toast.makeText(Order.this, "Incorrect! Try again!", Toast.LENGTH_SHORT).show();
                }
            }
            else /*Descending*/{
                if (SNum1.get() > SNum2.get() && SNum2.get() > SNum3.get() && SNum3.get() > SNum4.get() && SNum4.get() > SNum5.get()){
                    // To be replaced with another activity (Correct View)
                    Toast.makeText(Order.this, "Correct!", Toast.LENGTH_SHORT).show();
                    // Set correct to 1
                    correct = 1;
                }
                else{
                    // To be replaced with another activity (Incorrect View)
                    Toast.makeText(Order.this, "Incorrect! Try again!", Toast.LENGTH_SHORT).show();
                }
            }
            // clear the SelectedNum buttons
            SNum1.set(0);
            SNum2.set(0);
            SNum3.set(0);
            SNum4.set(0);
            SNum5.set(0);
            SelectedNum1.setText(R.string.NumPlaceholder);
            SelectedNum2.setText(R.string.NumPlaceholder);
            SelectedNum3.setText(R.string.NumPlaceholder);
            SelectedNum4.setText(R.string.NumPlaceholder);
            SelectedNum5.setText(R.string.NumPlaceholder);

            // if correct is 1, then randomize Order and randomnum1-5
            if (correct == 1) {
                // Random Order (Ascending or Descending)
                random.set((int) (Math.random() * 2));
                if (random.get() == 0) {
                    // Ascending
                    Order.set(1);
                    //Replace OrderTitle text with "Ascending"
                    TextView OrderTitle = findViewById(R.id.OrderQuestion);
                    OrderTitle.setText(R.string.please_select_the_numbers_in_ascending_order);
                } else {
                    // Descending
                    Order.set(0);
                    //Replace OrderTitle text with "Descending"
                    TextView OrderTitle = findViewById(R.id.OrderQuestion);
                    OrderTitle.setText(R.string.please_select_the_numbers_in_descending_order);
                }
                // Generate 5 random numbers as the options
                generateRandomNumbers(randomnum1, randomnum2, randomnum3, randomnum4, randomnum5);

            }

        });

        // Get the Back button
        Button Back = findViewById(R.id.BackButton);
        // Create a button listener
        Back.setOnClickListener(view -> {
            // End the activity
            finish();
        });

    }

    private void setNumber(AtomicInteger SNum1, AtomicInteger SNum2, AtomicInteger SNum3, AtomicInteger SNum4, AtomicInteger SNum5, AtomicInteger randomnum1, Button SelectedNum1, Button SelectedNum2, Button SelectedNum3, Button SelectedNum4, Button SelectedNum5) {
        // Check if Snum1 is empty
        if (SNum1.get() == 0) {
            // Set the value to Snum1
            SNum1.set(randomnum1.get());
            // Set the text to the SelectedNum button
            SelectedNum1.setText(String.valueOf(SNum1));
        }
        // else if Sum2 is empty
        else if (SNum2.get() == 0) {
            // Set the value to Snum2
            SNum2.set(randomnum1.get());
            // Set the text to the SelectedNum button
            SelectedNum2.setText(String.valueOf(SNum2));
        }
        // else if Sum3 is empty
        else if (SNum3.get() == 0) {
            // Set the value to Snum3
            SNum3.set(randomnum1.get());
            // Set the text to the SelectedNum button
            SelectedNum3.setText(String.valueOf(SNum3));
        }
        // else if Sum4 is empty
        else if (SNum4.get() == 0) {
            // Set the value to Snum4
            SNum4.set(randomnum1.get());
            // Set the text to the SelectedNum button
            SelectedNum4.setText(String.valueOf(SNum4));
        }
        // else
        else {
            // Set the value to Snum5
            SNum5.set(randomnum1.get());
            // Set the text to the SelectedNum button
            SelectedNum5.setText(String.valueOf(SNum5));
        }
    }
    private void generateRandomNumbers(AtomicInteger randomnum1, AtomicInteger randomnum2, AtomicInteger randomnum3, AtomicInteger randomnum4, AtomicInteger randomnum5) {
        // Random Number for Question
        randomnum1.set((int) (Math.random() * 100));
        randomnum2.set((int) (Math.random() * 100));
        randomnum3.set((int) (Math.random() * 100));
        randomnum4.set((int) (Math.random() * 100));
        randomnum5.set((int) (Math.random() * 100));

        // Set the 5 random numbers into the Num buttons
        Button num1 = findViewById(R.id.Num1);
        Button num2 = findViewById(R.id.Num2);
        Button num3 = findViewById(R.id.Num3);
        Button num4 = findViewById(R.id.Num4);
        Button num5 = findViewById(R.id.Num5);
        num1.setText(String.valueOf(randomnum1));
        num2.setText(String.valueOf(randomnum2));
        num3.setText(String.valueOf(randomnum3));
        num4.setText(String.valueOf(randomnum4));
        num5.setText(String.valueOf(randomnum5));

        // check if theres duplicates and zero
        if (randomnum1.get() == randomnum2.get() || randomnum1.get() == randomnum3.get() || randomnum1.get() == randomnum4.get() || randomnum1.get() == randomnum5.get() || randomnum2.get() == randomnum3.get() || randomnum2.get() == randomnum4.get() || randomnum2.get() == randomnum5.get() || randomnum3.get() == randomnum4.get() || randomnum3.get() == randomnum5.get() || randomnum4.get() == randomnum5.get() || randomnum1.get() == 0 || randomnum2.get() == 0 || randomnum3.get() == 0 || randomnum4.get() == 0 || randomnum5.get() == 0){
            generateRandomNumbers(randomnum1, randomnum2, randomnum3, randomnum4, randomnum5);
        }
    }
}