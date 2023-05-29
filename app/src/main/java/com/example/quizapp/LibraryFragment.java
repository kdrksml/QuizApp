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
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
                scoresRef.child("Science").orderByChild("highestScore").limitToLast(1).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                                int highestScore = userSnapshot.child("highestScore").getValue(Integer.class);
                                String highestScoreUsername = userSnapshot.child("username").getValue(String.class);

                                // Display the highest score and its username
                                scienceUsernameTextView.setText("" + highestScoreUsername);
                                scienceHighestScoreTextView.setText("" + highestScore);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Handle the error
                    }
                });

                // Retrieve literature scores
                scoresRef.child("Literature").orderByChild("highestScore").limitToLast(1).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                                int highestScore = userSnapshot.child("highestScore").getValue(Integer.class);
                                String highestScoreUsername = userSnapshot.child("username").getValue(String.class);

                                // Display the highest score and its username
                                literatureUsernameTextView.setText("" + highestScoreUsername);
                                literatureHighestScoreTextView.setText("" + highestScore);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Handle the error
                    }
                });

                // Retrieve art scores
                scoresRef.child("Art").orderByChild("highestScore").limitToLast(1).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                                int highestScore = userSnapshot.child("highestScore").getValue(Integer.class);
                                String highestScoreUsername = userSnapshot.child("username").getValue(String.class);

                                // Display the highest score and its username
                                artUsernameTextView.setText("" + highestScoreUsername);
                                artHighestScoreTextView.setText("" + highestScore);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Handle the error
                    }
                });

                // Retrieve movie scores
                scoresRef.child("Movie").orderByChild("highestScore").limitToLast(1).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                                int highestScore = userSnapshot.child("highestScore").getValue(Integer.class);
                                String highestScoreUsername = userSnapshot.child("username").getValue(String.class);

                                // Display the highest score and its username
                                movieUsernameTextView.setText("" + highestScoreUsername);
                                movieHighestScoreTextView.setText("" + highestScore);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Handle the error
                    }
                });

                // Retrieve geography scores
                scoresRef.child("Geography").orderByChild("highestScore").limitToLast(1).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                                int highestScore = userSnapshot.child("highestScore").getValue(Integer.class);
                                String highestScoreUsername = userSnapshot.child("username").getValue(String.class);

                                // Display the highest score and its username
                                geographyUsernameTextView.setText("" + highestScoreUsername);
                                geographyHighestScoreTextView.setText("" + highestScore);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Handle the error
                    }
                });

                // Retrieve history scores
                scoresRef.child("History").orderByChild("highestScore").limitToLast(1).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                                int highestScore = userSnapshot.child("highestScore").getValue(Integer.class);
                                String highestScoreUsername = userSnapshot.child("username").getValue(String.class);

                                // Display the highest score and its username
                                historyUsernameTextView.setText("" + highestScoreUsername);
                                historyHighestScoreTextView.setText("" + highestScore);
                            }
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



