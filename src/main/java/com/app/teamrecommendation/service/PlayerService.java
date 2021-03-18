package com.app.teamrecommendation.service;

import com.app.teamrecommendation.model.Player;

import java.util.List;

public interface PlayerService {
    void addPlayer(Player player);

    void deletePlayer(String playerId);

    Player getPlayerDetails(String playerId);

    void updatePlayerDetails(Player player);

    List<Player> getAllPlayers();

    void addPlayers(List<Player> players);

    void updatePlayers(List<Player> players);

    void deleteAllPlayers();
}
