package com.app.teamrecommendation.service;

import com.app.teamrecommendation.model.Match;

import java.util.List;

public interface MatchService {
    void createMatch(Match match);

    Match getMatchDetails(String matchId);

    List<Match> getAllMatches();

    void updateMatchDetails(Match match);

    void deleteMatch(String matchId);

    void deleteAllMatches();
}
