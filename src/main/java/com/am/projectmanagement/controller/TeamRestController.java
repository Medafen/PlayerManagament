package com.am.projectmanagement.controller;

import com.am.projectmanagement.model.Team;
import com.am.projectmanagement.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamRestController {
    private TeamService teamService;

    @Autowired
    public TeamRestController(TeamService teamService){
        this.teamService = teamService;
    }
    @GetMapping("/teams/{teamId}")
    ResponseEntity<Team> getTeam(@PathVariable Integer teamId) {
        return ResponseEntity.of(teamService.getTeam(teamId));
    }
    @PostMapping(path = "/team")
    ResponseEntity<Void> createTeam(@Valid @RequestBody Team team) {

        Team createdTeam = teamService.addTeam(team);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{teamId}").buildAndExpand(createdTeam.getTeamId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/team/{teamId}")
    public ResponseEntity<Void> updateTeam(@Valid @RequestBody Team team,
                                           @PathVariable Integer teamId) {
        return teamService.getTeam(teamId)
                .map(p -> {
                    teamService.addTeam(team);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/deleteTeam/{teamId}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Integer teamId) {
        return teamService.getTeam(teamId).map(p -> {
            teamService.deleteTeam(teamId);
            return new ResponseEntity<Void>(HttpStatus.OK); // 200
        }).orElseGet(() -> ResponseEntity.notFound().build()); // 404 - Not found
    }
    @GetMapping(value = "/teams")
    List<Team> getTeams() { // @RequestHeader HttpHeaders headers � je�eli potrzebny
        return teamService.getTeams(); // by�by nag��wek, wystarczy doda� drug� zmienn� z adnotacj�
    }
}
