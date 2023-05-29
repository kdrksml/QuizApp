package com.example.quizapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LibraryFragment extends Fragment {

    private TextView scienceUsernameTextView;
    private TextView literatureUsernameTextView;
    private TextView artUsernameTextView;
    private TextView movieUsernameTextView;
    private TextView geographyUsernameTextView;
    private TextView historyUsernameTextView;

    private TextView scienceHighestScoreTextView;
    private TextView literatureHighestScoreTextView;
    private TextView artHighestScoreTextView;
    private TextView movieHighestScoreTextView;
    private TextView geographyHighestScoreTextView;
    private TextView historyHighestScoreTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);

        // Initialize TextViews for username
        scienceUsernameTextView = view.findViewById(R.id.scienceUsername);
        literatureUsernameTextView = view.findViewById(R.id.literatureUsername);
        artUsernameTextView = view.findViewById(R.id.artUsername);
        movieUsernameTextView = view.findViewById(R.id.movieUsername);
        geographyUsernameTextView = view.findViewById(R.id.geographyUsername);
        historyUsernameTextView = view.findViewById(R.id.historyUsername);

        // Initialize TextViews for highest score
        scienceHighestScoreTextView = view.findViewById(R.id.scienceHighestScore);
        literatureHighestScoreTextView = view.findViewById(R.id.literatureHighestScore);
        artHighestScoreTextView = view.findViewById(R.id.artHighestScore);
        movieHighestScoreTextView = view.findViewById(R.id.movieHighestScore);
        geographyHighestScoreTextView = view.findViewById(R.id.geographyHighestScore);
        historyHighestScoreTextView = view.findViewById(R.id.historyHighestScore);

        // Retrieve user ID
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String uid = currentUser.getUid();
            DatabaseReference scoresRef = FirebaseDatabase.getInstance().getReference("scores");

            // Retrieve science scores
            scoresRef.child("science").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        String username = dataSnapshot.child("username").getValue(String.class);
                        int highestScore = dataSnapshot.child("highestScore").getValue(Integer.class);
                        scienceUsernameTextView.setText("Username: " + username);
                        scienceHighestScoreTextView.setText("Highest Score: " + highestScore);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle the error
                }
            });

            // Retrieve literature scores
            scoresRef.child("literature").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        String username = dataSnapshot.child("username").getValue(String.class);
                        int highestScore = dataSnapshot.child("highestScore").getValue(Integer.class);
                        literatureUsernameTextView.setText("Username: " + username);
                        literatureHighestScoreTextView.setText("Highest Score: " + highestScore);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle the error
                }
            });

            // Retrieve art scores
            scoresRef.child("art").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        String username = dataSnapshot.child("username").getValue(String.class);
                        int highestScore = dataSnapshot.child("highestScore").getValue(Integer.class);
                        artUsernameTextView.setText("Username: " + username);
                        artHighestScoreTextView.setText("Highest Score: " + highestScore);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle the error
                }
            });

            // Retrieve movie scores
            scoresRef.child("movie").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        String username = dataSnapshot.child("username").getValue(String.class);
                        int highestScore = dataSnapshot.child("highestScore").getValue(Integer.class);
                        movieUsernameTextView.setText("Username: " + username);
                        movieHighestScoreTextView.setText("Highest Score: " + highestScore);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle the error
                }
            });

            // Retrieve geography scores
            scoresRef.child("geography").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        String username = dataSnapshot.child("username").getValue(String.class);
                        int highestScore = dataSnapshot.child("highestScore").getValue(Integer.class);
                        geographyUsernameTextView.setText("Username: " + username);
                        geographyHighestScoreTextView.setText("Highest Score: " + highestScore);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle the error
                }
            });

            // Retrieve history scores
            scoresRef.child("history").child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        String username = dataSnapshot.child("username").getValue(String.class);
                        int highestScore = dataSnapshot.child("highestScore").getValue(Integer.class);
                        historyUsernameTextView.setText("Username: " + username);
                        historyHighestScoreTextView.setText("Highest Score: " + highestScore);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Handle the error
                }
            });
        }

        return view;
    }
}

