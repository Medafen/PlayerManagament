package com.am.projectmanagement.controller;

import com.am.projectmanagement.model.Player;
import com.am.projectmanagement.service.PlayerService;
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
public class PlayerRestController {
    private PlayerService playerService;
    @Autowired
    public PlayerRestController(PlayerService playerService){
        this.playerService = playerService;
    }
    @GetMapping("/players/{playerId}")
    ResponseEntity<Player> getPlayer(@PathVariable Integer playerId) {
        return ResponseEntity.of(playerService.getPlayer(playerId));
    }
    @PostMapping(path = "/addPlayer")
    ResponseEntity<Void> createPlayer(@Valid @RequestBody Player player) {

        Player createdPlayer = playerService.addPlayer(player);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{playerId}").buildAndExpand(createdPlayer.getPlayerId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/updatePlayer/{playerId}")
    public ResponseEntity<Void> updatePlayer(@Valid @RequestBody Player player,
                                             @PathVariable Integer playerId) {
        return playerService.getPlayer(playerId)
                .map(p -> {
                    playerService.updatePlayer(player);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/deletePlayer/{playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Integer playerId) {
        return playerService.getPlayer(playerId).map(p -> {
            playerService.deletePlayer(playerId);
            return new ResponseEntity<Void>(HttpStatus.OK); // 200
        }).orElseGet(() -> ResponseEntity.notFound().build()); // 404 - Not found
    }
    @GetMapping(value = "/players")
    List<Player> getPlayers() { // @RequestHeader HttpHeaders headers � je�eli potrzebny
        return playerService.getPlayers(); // by�by nag��wek, wystarczy doda� drug� zmienn� z adnotacj�
    }
}
