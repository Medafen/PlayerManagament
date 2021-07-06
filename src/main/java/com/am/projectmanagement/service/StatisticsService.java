package com.am.projectmanagement.service;

import com.am.projectmanagement.model.Player;
import com.am.projectmanagement.model.Statistics;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StatisticsService {
    Optional<Statistics> getStatistics(Integer statisticsId);
    Statistics addStatistics (Statistics statistics);
    void deleteStatistics (Integer statisticsId);
    List<Statistics> getStatistics();
    List<Statistics> getPlayerStatistics(Player player);
    Statistics updateStatistics(Statistics statistics);
   // void setStatistics(Player player, Statistics statistics);
}
