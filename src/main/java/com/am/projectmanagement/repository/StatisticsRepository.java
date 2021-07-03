package com.am.projectmanagement.repository;

import com.am.projectmanagement.model.Player;
import com.am.projectmanagement.model.Statistics;
import com.am.projectmanagement.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StatisticsRepository extends JpaRepository<Statistics,Integer> {
    @Query("SELECT z FROM Statistics z WHERE z.player = :player")
    List<Statistics> findStatisticsByPlayer(@Param("team") Player player);
}
