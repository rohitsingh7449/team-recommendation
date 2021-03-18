package com.app.teamrecommendation.service.impl;

import com.app.teamrecommendation.dao.MatchDao;
import com.app.teamrecommendation.model.Match;
import com.app.teamrecommendation.service.MatchService;
import com.app.teamrecommendation.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    MatchDao matchDao;

    @Autowired
    PlayerService playerService;
    @Override
    public void createMatch(Match match) {
        //Get All players from database , in order to reduce network calls
        //List<Player> players = playerService.getAllPlayers();
        List<String> playerIdList = match.getPlayers();
        for(String playerId : playerIdList){
            if(playerService.getPlayerDetails(playerId)==null){
                throw new RuntimeException("No Player found with Player Id : "+playerId);
            }
        }
        matchDao.insert(match);
    }

    @Override
    public Match getMatchDetails(String matchId) {
        return matchDao.findById(matchId).get();
    }

    @Override
    public List<Match> getAllMatches() {
        return matchDao.findAll();
    }

    @Override
    public void updateMatchDetails(Match match) {
        List<String> playerIdList = match.getPlayers();
        for(String playerId : playerIdList){
            if(playerService.getPlayerDetails(playerId)==null){
                throw new RuntimeException("No Player found with Player Id : "+playerId);
            }
        }
        matchDao.save(match);
    }

    @Override
    public void deleteMatch(String matchId) {
        if (getMatchDetails(matchId) != null) {
            matchDao.deleteById(matchId);
        } else {
            logger.info("No match found for matchId : {}", matchId);
        }
    }

    @Override
    public void deleteAllMatches() {
        matchDao.deleteAll();
    }
}
