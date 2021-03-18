package com.app.teamrecommendation.service.impl;

import com.app.teamrecommendation.model.Formation;
import com.app.teamrecommendation.model.Team;
import com.app.teamrecommendation.service.FormationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormationServiceImpl implements FormationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final int TOTAL_CREDIT=100;
    @Override
    public void createFormation(Formation formation) {
        //validate the formation
        if(isValidFormation(formation)){
            logger.info("Formation is valid for FormationId : {}",formation.getFormationId());
            createTeams(formation);
        }else{
            throw new RuntimeException("Invalid combination. Please select valid combination");
        }
    }

    private void createTeams(Formation formation) {
        List<Team> teams = new ArrayList<>();
        //Get the recommended player to be added in each team
        List<String> recommendedPlayers = formation.getRecommendedPlayers();
        if(recommendedPlayers.size()!=0){

        }else{
            logger.info("No Players has been recommended by user, creating teams based on formation");
        }

    }

    @Override
    public Formation getFormationById(String matchId, String formationId) {
        return null;
    }

    @Override
    public List<Formation> getFormationbyMatchId(String matchId) {
        return null;
    }

    private boolean isValidFormation(Formation formation) {
        //check if number of player is greater than 11
        int numOfPlayers = formation.getNumberOfBatsman() + formation.getNumberOfBowlers() + formation.getNumberOfAllRounders() + formation.getNumberOfWicketKeepers();
        if(numOfPlayers >11){
            return false;
        }
        return true;
    }
}
