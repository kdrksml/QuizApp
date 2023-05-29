package com.example.quizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LibraryFragment extends Fragment {

    private TableLayout scoreTable;
    private DatabaseReference scoresRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        scoreTable = view.findViewById(R.id.scoreTable);

        scoresRef = FirebaseDatabase.getInstance().getReference("scores");

        displayScoreTable();

        return view;
    }

    private void displayScoreTable() {
        // Retrieve scores for each category
        retrieveScoresForCategory("Science", R.id.scienceUsername, R.id.scienceHighestScore);
        retrieveScoresForCategory("Literature", R.id.literatureUsername, R.id.literatureHighestScore);
        retrieveScoresForCategory("Art", R.id.artUsername, R.id.artHighestScore);
        retrieveScoresForCategory("Movie", R.id.movieUsername, R.id.movieHighestScore);
        retrieveScoresForCategory("Geography", R.id.geographyUsername, R.id.geographyHighestScore);
        retrieveScoresForCategory("History", R.id.historyUsername, R.id.historyHighestScore);
    }

    private void retrieveScoresForCategory(String category, int usernameTextViewId, int highestScoreTextViewId) {
        Query query = scoresRef.child(category).orderByChild("highestScore").limitToLast(10);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String username = dataSnapshot.child("username").getValue(String.class);
                    int highestScore = dataSnapshot.child("highestScore").getValue(Integer.class);

                    TextView usernameTextView = getView().findViewById(usernameTextViewId);
                    TextView highestScoreTextView = getView().findViewById(highestScoreTextViewId);

                    if (usernameTextView != null && highestScoreTextView != null) {
                        usernameTextView.setText(username);
                        highestScoreTextView.setText(String.valueOf(highestScore));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle database error
            }
        });
    }
}

