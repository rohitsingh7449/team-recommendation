package com.app.teamrecommendation.controller;

import com.app.teamrecommendation.model.Player;
import com.app.teamrecommendation.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    PlayerService playerService;

    @RequestMapping("/health-check")
    public String healthcheck() {
        return "Service is running";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Player> getAllplayers(){
        return playerService.getAllPlayers();
    }

    @RequestMapping(method=RequestMethod.POST)
    public void addPlayers(@RequestBody List<Player> players){
        playerService.addPlayers(players);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllPlayers(){
        playerService.deleteAllPlayers();
    }

    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public void updatePlayer(@RequestBody Player player){
        Player playerDB = playerService.getPlayerDetails(player.getPlayerId());
        if(playerDB.getPlayerId()==null){
            logger.info("No Player Found with PlayerId : {}. Saving this as new record",player.getPlayerId());
            return;
        }
        playerService.updatePlayerDetails(player);
    }

    @RequestMapping(value="/{playerId}",method = RequestMethod.GET)
    public Player getPlayerById(@PathVariable String playerId){
        return playerService.getPlayerDetails(playerId);
    }

    @RequestMapping(value="/{playerId}",method = RequestMethod.DELETE)
    public void deletePlayerById(@PathVariable String playerId){
        playerService.deletePlayer(playerId);
    }
}
