package com.app.teamrecommendation.service;

import com.app.teamrecommendation.model.Formation;

import java.util.List;

public interface FormationService {
    void createFormation(Formation formation);

    Formation getFormationById(String matchId, String formationId);

    List<Formation> getFormationbyMatchId(String matchId);
}
