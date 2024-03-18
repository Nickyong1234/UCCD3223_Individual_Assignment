package my.edu.utar.individualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Compare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        // declare a new int variable
        int BigOrSmall;


        // Random either Bigger or Smaller
        int random = (int) (Math.random() * 2);
        if (random == 0) {
            // Bigger
            BigOrSmall = 1;
            //Replace CompareTitle text with "Bigger"
            TextView CompareTitle = findViewById(R.id.CompareQuestion);
            CompareTitle.setText(R.string.please_select_a_bigger_number);

        } else {
            // Smaller
            BigOrSmall = 0;
            //Replace CompareTitle text with "Smaller"
            TextView CompareTitle = findViewById(R.id.CompareQuestion);
            CompareTitle.setText(R.string.please_select_a_smaller_number);
        }

    }
}