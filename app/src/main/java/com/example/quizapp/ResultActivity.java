package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ResultActivity extends AppCompatActivity {

    MaterialCardView home;
    TextView correctt, wrongt, resultinfo, resultscore;
    ImageView resultImage;
    DatabaseReference userProfileRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        home = findViewById(R.id.returnHome);
        correctt = findViewById(R.id.correctScore);
        wrongt = findViewById(R.id.wrongScore);
        resultinfo = findViewById(R.id.resultInfo);
        resultscore = findViewById(R.id.resultScore);
        resultImage = findViewById(R.id.resultImage);

        int correct = getIntent().getIntExtra("correct", 0);
        int wrong = getIntent().getIntExtra("wrong", 0);
        int score = correct * 10;

        correctt.setText(String.valueOf(correct));
        wrongt.setText(String.valueOf(wrong));
        resultscore.setText(String.valueOf(score));

        if (correct >= 0 && correct <= 2) {
            resultinfo.setText("Test sonucunuz gelişmeye ihtiyaç gösteriyor.");
            resultImage.setImageResource(R.drawable.ic_sad);
        } else if (correct >= 3 && correct <= 5) {
            resultinfo.setText("Biraz daha çaba göstermeniz gerekiyor");
            resultImage.setImageResource(R.drawable.ic_neutral);
        } else if (correct >= 6 && correct <= 8) {
            resultinfo.setText("Güzel bir sonuç, tebrikler");
            resultImage.setImageResource(R.drawable.ic_smile);
        } else {
            resultinfo.setText("Harika bir sonuç, tebrikler");
            resultImage.setImageResource(R.drawable.ic_smile);
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String category = getIntent().getStringExtra("category");
                saveScore(score, category); // Save the score in the user's profile
                saveHighestScoreAndUsername(score, category); // Save the highest score and username
                startActivity(new Intent(ResultActivity.this, Homepage.class));
                finish();
            }
        });
    }

    private void saveScore(int score, String category) {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            userProfileRef = FirebaseDatabase.getInstance().getReference("user_profiles").child(userId);

            // Update the score in the user's profile based on the category
            switch (category) {
                case "Art":
                    userProfileRef.child("artHighestScore").setValue(score);
                    break;
                case "Science":
                    userProfileRef.child("scienceHighestScore").setValue(score);
                    break;
                case "Literature":
                    userProfileRef.child("literatureHighestScore").setValue(score);
                    break;
                case "Geography":
                    userProfileRef.child("geographyHighestScore").setValue(score);
                    break;
                case "Movie":
                    userProfileRef.child("movieHighestScore").setValue(score);
                    break;
                case "History":
                    userProfileRef.child("historyHighestScore").setValue(score);
                    break;
            }
        }
    }

    private void saveHighestScoreAndUsername(int score, String category) {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();

            DatabaseReference userProfileRef = FirebaseDatabase.getInstance().getReference("user_profiles").child(userId);
            userProfileRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        String username = dataSnapshot.child("username").getValue(String.class);

                        DatabaseReference scoreRef = FirebaseDatabase.getInstance().getReference("scores")
                                .child(category).child(userId);

                        scoreRef.child("highestScore").setValue(score);
                        scoreRef.child("username").setValue(username);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle any errors
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ResultActivity.this, Homepage.class));
        finish();
    }
}
