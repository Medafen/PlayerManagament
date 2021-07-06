package com.am.projectmanagement.service;

import com.am.projectmanagement.model.Player;
import com.am.projectmanagement.model.Statistics;
import com.am.projectmanagement.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StatisticsServiceImpl implements StatisticsService{
    private StatisticsRepository statisticsRepository;

    @Autowired
    public  StatisticsServiceImpl(StatisticsRepository statisticsRepository){
        this.statisticsRepository=statisticsRepository;
    }

    @Override
    public Optional<Statistics> getStatistics(Integer statisticsId) {
        return statisticsRepository.findById(statisticsId);
    }

    @Override
    public Statistics addStatistics(Statistics statistics) {
        return statisticsRepository.save(statistics);
    }

    @Override
    public void deleteStatistics(Integer statisticsId) {
        statisticsRepository.deleteById(statisticsId);
    }

    @Override
    public List<Statistics> getStatistics() {
        return statisticsRepository.findAll();
    }

    @Override
    public List<Statistics> getPlayerStatistics(Player player) {
        return null;
    }

//    @Override
//    public List<Statistics> getPlayerStatistics(Player player) {
//        return statisticsRepository.findStatisticsByPlayer(player);
//    }

    @Override
    public Statistics updateStatistics(Statistics statistics) {
        Statistics updateStatistics = statisticsRepository.findById(statistics.getStatisticsId()).orElse(null);
        updateStatistics.setFarming(statistics.getFarming());
        updateStatistics.setLaning(statistics.getLaning());
        updateStatistics.setPathing(statistics.getPathing());
        updateStatistics.setRoaming(statistics.getRoaming());
        updateStatistics.setMapAwarness(statistics.getMapAwarness());
        updateStatistics.setTeamFigting(statistics.getTeamFigting());
        return statisticsRepository.save(updateStatistics);
    }

//    @Override
//    public void setStatistics(Player player, Statistics statistics) {
//        statistics.setPlayer(player);
//        statisticsRepository.save(statistics);
//    }

}
