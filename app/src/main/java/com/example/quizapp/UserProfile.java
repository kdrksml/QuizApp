package com.example.quizapp;

public class UserProfile {
    private String userId;
    private String username;
    private String email;
    private int scienceHighestScore;
    private int literatureHighestScore;
    private int historyHighestScore;
    private int geographyHighestScore;
    private int movieHighestScore;
    private int artHighestScore;

    public UserProfile() {
        // Default constructor required for Firebase
    }

    public UserProfile(String userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    // Getters and setters for other attributes...

    // Add getters and setters for userId, username, and email

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScienceHighestScore() {
        return scienceHighestScore;
    }

    public void setScienceHighestScore(int scienceHighestScore) {
        this.scienceHighestScore = scienceHighestScore;
    }

    public int getLiteratureHighestScore() {
        return literatureHighestScore;
    }

    public void setLiteratureHighestScore(int literatureHighestScore) {
        this.literatureHighestScore = literatureHighestScore;
    }

    public int getHistoryHighestScore() {
        return historyHighestScore;
    }

    public void setHistoryHighestScore(int historyHighestScore) {
        this.historyHighestScore = historyHighestScore;
    }

    public int getGeographyHighestScore() {
        return geographyHighestScore;
    }

    public void setGeographyHighestScore(int geographyHighestScore) {
        this.geographyHighestScore = geographyHighestScore;
    }

    public int getMovieHighestScore() {
        return movieHighestScore;
    }

    public void setMovieHighestScore(int movieHighestScore) {
        this.movieHighestScore = movieHighestScore;
    }

    public int getArtHighestScore() {
        return artHighestScore;
    }

    public void setArtHighestScore(int artHighestScore) {
        this.artHighestScore = artHighestScore;
    }
}


