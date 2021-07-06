package com.am.projectmanagement.service;

import com.am.projectmanagement.model.Team;
import com.am.projectmanagement.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TeamServiceImpl implements TeamService {
    private TeamRepository teamRepository;


    public TeamServiceImpl(){

    }

    @Override
    public Optional<Team> getTeam(Integer teamId) {
        return teamRepository.findById(teamId);
    }

    @Override
    public Team addTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Integer teamId) {
        teamRepository.deleteById(teamId);
    }

    @Override
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }
}
