package com.app.teamrecommendation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "formations")
public class Formation {
    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    @Id
    private String formationId;
    private String matchId;
    private int numberOfBatsman;

    public String getFormationId() {
        return formationId;
    }

    public void setFormationId(String formationId) {
        this.formationId = formationId;
    }

    private int numberOfBowlers;
    private int numberOfWicketKeepers;
    private int numberOfAllRounders;

    private List<String> recommendedPlayers;

    public int getNumberOfBatsman() {
        return numberOfBatsman;
    }

    public void setNumberOfBatsman(int numberOfBatsman) {
        this.numberOfBatsman = numberOfBatsman;
    }

    public int getNumberOfBowlers() {
        return numberOfBowlers;
    }

    public void setNumberOfBowlers(int numberOfBowlers) {
        this.numberOfBowlers = numberOfBowlers;
    }

    public int getNumberOfWicketKeepers() {
        return numberOfWicketKeepers;
    }

    public void setNumberOfWicketKeepers(int numberOfWicketKeepers) {
        this.numberOfWicketKeepers = numberOfWicketKeepers;
    }

    public int getNumberOfAllRounders() {
        return numberOfAllRounders;
    }

    public void setNumberOfAllRounders(int numberOfAllRounders) {
        this.numberOfAllRounders = numberOfAllRounders;
    }

    public List<String> getRecommendedPlayers() {
        return recommendedPlayers;
    }

    public void setRecommendedPlayers(List<String> recommendedPlayers) {
        this.recommendedPlayers = recommendedPlayers;
    }

    @Override
    public String toString() {
        return "Formation{" +
                "formationId='" + formationId + '\'' +
                ", matchId='" + matchId + '\'' +
                ", numberOfBatsman=" + numberOfBatsman +
                ", numberOfBowlers=" + numberOfBowlers +
                ", numberOfWicketKeepers=" + numberOfWicketKeepers +
                ", numberOfAllRounders=" + numberOfAllRounders +
                ", recommendedPlayers=" + recommendedPlayers +
                '}';
    }
}
