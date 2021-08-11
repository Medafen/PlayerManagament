package com.am.projectmanagement.service;

import com.am.projectmanagement.model.Player;
import com.am.projectmanagement.model.Team;
import com.am.projectmanagement.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlayerServiceImpl implements PlayerService{
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    @Override
    public Optional<Player> getPlayer(Integer playerId) {
        return playerRepository.findById(playerId);
    }

    @Override
    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Integer playerId) {
        playerRepository.deleteById(playerId);
    }

    @Override
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> getPlayersFromTeam(Team team) {
        return playerRepository.findPlayersByTeam(team);
    }

    @Override
    public Player updatePlayer(Player player) {
        Player updatePlayer = playerRepository.findById(player.getPlayerId()).orElse(null);
        updatePlayer.setElo(player.getElo());
        updatePlayer.setNickname(player.getNickname());
        updatePlayer.setRole(player.getRole());
        updatePlayer.setStatistics(player.getStatistics());
        updatePlayer.setName(player.getName());
        updatePlayer.setSurname(player.getSurname());
        updatePlayer.setStatistics(player.getStatistics());
        updatePlayer.setTeam(player.getTeam());
        return playerRepository.save(updatePlayer);
    }

    @Override
    public void setTeam(Player player, Team team) {
        player.setTeam(team);
        playerRepository.save(player);
    }
}
