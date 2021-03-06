package com.am.projectmanagement.service;

import com.am.projectmanagement.model.Player;
import com.am.projectmanagement.model.Team;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlayerService {
    Optional<Player> getPlayer(Integer playerId);
    Player addPlayer(Player player);
    void deletePlayer(Integer playerId);
    List<Player> getPlayers();
    List<Player> getPlayersFromTeam(Team team);
    Player updatePlayer(Player player);
    void setTeam(Player player, Team team);
}
