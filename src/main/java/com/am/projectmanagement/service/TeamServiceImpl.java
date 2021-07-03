package com.am.projectmanagement.service;

import com.am.projectmanagement.model.Team;
import com.am.projectmanagement.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

public class TeamsServiceImpl implements TeamsService{
    private TeamRepository teamRepository;

    @Override
    public Optional<Team> getTeam(Integer teamId) {
        return Optional.empty();
    }

    @Override
    public Team addTeam(Team team) {
        return null;
    }

    @Override
    public void deleteTeam(Integer teamId) {

    }

    @Override
    public List<Team> getTeams() {
        return null;
    }
}
