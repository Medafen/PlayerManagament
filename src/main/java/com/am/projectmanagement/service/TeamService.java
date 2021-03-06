package com.am.projectmanagement.service;

import com.am.projectmanagement.model.Team;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TeamService {
    Optional<Team> getTeam(Integer teamId);
    Team addTeam(Team team);
    void deleteTeam(Integer teamId);
    List<Team> getTeams();
}
