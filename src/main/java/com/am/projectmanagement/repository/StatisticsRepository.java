package com.am.projectmanagement.repository;

import com.am.projectmanagement.model.Player;
import com.am.projectmanagement.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics,Integer> {
    @Query("SELECT z FROM Statistics z WHERE z.player = :player")
    List<Statistics> findStatisticsByPlayer(@Param("player") Player player);
}
