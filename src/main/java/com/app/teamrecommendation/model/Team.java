package com.app.teamrecommendation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "teams")
public class Team {
    @Id
    private String teamId;
    private String matchId;
    private String formationId;

    private List<String> players;

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getFormationId() {
        return formationId;
    }

    public void setFormationId(String formationId) {
        this.formationId = formationId;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "matchId='" + matchId + '\'' +
                ", formationId='" + formationId + '\'' +
                ", teamId='" + teamId + '\'' +
                ", players=" + players +
                '}';
    }
}
