package com.am.projectmanagement.repository;

import com.am.projectmanagement.model.Player;
import com.am.projectmanagement.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query("SELECT z FROM Player z WHERE z.team = :teamRepostory")
    List<Player> findPlayersByTeam(@Param("team") Team teamRepository);
}
