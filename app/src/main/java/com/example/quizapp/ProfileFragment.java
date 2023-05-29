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

public class ProfileFragment extends Fragment {

    private TextView usernameTextView;
    private TextView emailTextView;
    private TextView scienceScoreTextView;
    private TextView literatureScoreTextView;
    private TextView historyScoreTextView;
    private TextView geographyScoreTextView;
    private TextView movieScoreTextView;
    private TextView artScoreTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize TextViews
        usernameTextView = view.findViewById(R.id.usernameTextView);
        emailTextView = view.findViewById(R.id.emailTextView);
        scienceScoreTextView = view.findViewById(R.id.scienceScoreTextView);
        literatureScoreTextView = view.findViewById(R.id.literatureScoreTextView);
        historyScoreTextView = view.findViewById(R.id.historyScoreTextView);
        geographyScoreTextView = view.findViewById(R.id.geographyScoreTextView);
        movieScoreTextView = view.findViewById(R.id.movieScoreTextView);
        artScoreTextView = view.findViewById(R.id.artScoreTextView);

        // Retrieve user profile data from Firebase and set the values
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String uid = currentUser.getUid();
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("user_profiles").child(uid);
            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                        if (userProfile != null) {
                            String username = userProfile.getUsername();
                            String email = userProfile.getEmail();
                            int scienceScore = userProfile.getScienceHighestScore();
                            int literatureScore = userProfile.getLiteratureHighestScore();
                            int historyScore = userProfile.getHistoryHighestScore();
                            int geographyScore = userProfile.getGeographyHighestScore();
                            int movieScore = userProfile.getMovieHighestScore();
                            int artScore = userProfile.getArtHighestScore();

                            // Set the username and email values in the TextViews
                            usernameTextView.setText(username);
                            emailTextView.setText(email);

                            // Set the scores for different categories in the TextViews
                            scienceScoreTextView.setText("Science: " + String.valueOf(scienceScore));
                            literatureScoreTextView.setText("Literature: " + String.valueOf(literatureScore));
                            historyScoreTextView.setText("History: " + String.valueOf(historyScore));
                            geographyScoreTextView.setText("Geography: " + String.valueOf(geographyScore));
                            movieScoreTextView.setText("Movie: " + String.valueOf(movieScore));
                            artScoreTextView.setText("Art: " + String.valueOf(artScore));
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


