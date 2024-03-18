package my.edu.utar.individualassignment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

public class Compare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        // declare a new int variable
        //int BigOrSmall;
        AtomicInteger BigOrSmall = new AtomicInteger();
        AtomicInteger randomleft = new AtomicInteger();
        AtomicInteger randomright = new AtomicInteger();

        // Random either Bigger or Smaller
        int random = (int) (Math.random() * 2);
        if (random == 0) {
            // Bigger
            BigOrSmall.set(1);
            //Replace CompareTitle text with "Bigger"
            TextView CompareTitle = findViewById(R.id.ComposeQuestion);
            CompareTitle.setText(R.string.please_select_a_bigger_number);

        }
        else {
            // Smaller
            BigOrSmall.set(0);
            //Replace CompareTitle text with "Smaller"
            TextView CompareTitle = findViewById(R.id.ComposeQuestion);
            CompareTitle.setText(R.string.please_select_a_smaller_number);
        }

        // Get the button
        Button button_left = findViewById(R.id.button_left);
        Button button_right = findViewById(R.id.button_right);

        // Create 2 random integers and set text to the buttons
        randomleft.set((int) (Math.random() * 100));
        randomright.set((int) (Math.random() * 100));
        button_left.setText(String.valueOf(randomleft));
        button_right.setText(String.valueOf(randomright));

        // Create a button listener
        button_left.setOnClickListener(view -> {
            // Create an intent to start the compare activity
            if (BigOrSmall.get() == 1 /*Bigger*/) {
                if (randomleft.get() > randomright.get()){
                    // To be replaced with another activity (Correct View)
                    Toast.makeText(Compare.this, "Correct!", Toast.LENGTH_SHORT).show();
                }
                else {
                    // To be replaced with another activity (Incorrect View)
                    Toast.makeText(Compare.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
            else /*Smaller*/{
                if (randomleft.get() < randomright.get()){
                    // To be replaced with another activity (Correct View)
                    Toast.makeText(Compare.this, "Correct!", Toast.LENGTH_SHORT).show();
                }
                else{
                    // To be replaced with another activity (Incorrect View)
                    Toast.makeText(Compare.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
            // Randomize BigOrSmall, randomleft, and randomright
            BigOrSmall.set((int) (Math.random() * 2));
            randomleft.set((int) (Math.random() * 100));
            randomright.set((int) (Math.random() * 100));
            // Update the text of the buttons and ComposeQuestion
            button_left.setText(String.valueOf(randomleft));
            button_right.setText(String.valueOf(randomright));
            if (BigOrSmall.get() == 1) {
                TextView CompareTitle = findViewById(R.id.ComposeQuestion);
                CompareTitle.setText(R.string.please_select_a_bigger_number);
            }
            else {
                TextView CompareTitle = findViewById(R.id.ComposeQuestion);
                CompareTitle.setText(R.string.please_select_a_smaller_number);
            }
            /*Intent intent = new Intent(Compare.this, Compare.class);
            // Start the activity
            startActivity(intent);*/
        });

        // Create a button listener
        button_right.setOnClickListener(view -> {
            // Create an intent to start the compare activity
            if (BigOrSmall.get() == 1 /*Bigger*/) {
                if (randomright.get() > randomleft.get()){
                    // To be replaced with another activity (Correct View)
                    Toast.makeText(Compare.this, "Correct!", Toast.LENGTH_SHORT).show();
                }
                else {
                    // To be replaced with another activity (Incorrect View)
                    Toast.makeText(Compare.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
            else /*Smaller*/{
                if (randomright.get() < randomleft.get()){
                    // To be replaced with another activity (Correct View)
                    Toast.makeText(Compare.this, "Correct!", Toast.LENGTH_SHORT).show();
                }
                else{
                    // To be replaced with another activity (Incorrect View)
                    Toast.makeText(Compare.this, "Wrong!", Toast.LENGTH_SHORT).show();
                }
            }
            // Randomize BigOrSmall, randomleft, and randomright
            BigOrSmall.set((int) (Math.random() * 2));
            randomleft.set((int) (Math.random() * 100));
            randomright.set((int) (Math.random() * 100));
            // Update the text of the buttons and ComposeQuestion
            button_left.setText(String.valueOf(randomleft));
            button_right.setText(String.valueOf(randomright));
            if (BigOrSmall.get() == 1) {
                TextView CompareTitle = findViewById(R.id.ComposeQuestion);
                CompareTitle.setText(R.string.please_select_a_bigger_number);
            }
            else {
                TextView CompareTitle = findViewById(R.id.ComposeQuestion);
                CompareTitle.setText(R.string.please_select_a_smaller_number);
            }
            /*Intent intent = new Intent(Compare.this, Compare.class);
            // Start the activity
            startActivity(intent);*/
        });

        // Get the BackButton button
        Button back = findViewById(R.id.BackButton);
        // Create a button listener
        back.setOnClickListener(view -> {
            // End the activity
            finish();
        });
    }

}