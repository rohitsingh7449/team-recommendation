package com.app.teamrecommendation.service.impl;

import com.app.teamrecommendation.dao.PlayerDao;
import com.app.teamrecommendation.model.Player;
import com.app.teamrecommendation.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerDao playerDao;

    @Override
    public void addPlayer(Player player) {
        playerDao.insert(player);
    }

    @Override
    public void deletePlayer(String playerId) {
        Optional<Player> player = playerDao.findById(playerId);
        if(!player.isEmpty()){
            playerDao.delete(player.get());
        }else{
            logger.info("Player not found for Id : {}",playerId);
        }
    }

    @Override
    public Player getPlayerDetails(String playerId) {
        return playerDao.findById(playerId).get();
    }

    @Override
    public void updatePlayerDetails(Player player) {
        playerDao.save(player);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerDao.findAll();
    }

    @Override
    public void addPlayers(List<Player> players) {
        playerDao.insert(players);
    }

    @Override
    public void updatePlayers(List<Player> players) {
        playerDao.saveAll(players);
    }

    @Override
    public void deleteAllPlayers() {
        playerDao.deleteAll();
    }
}
