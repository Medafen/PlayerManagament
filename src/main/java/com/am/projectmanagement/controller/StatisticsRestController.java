package com.am.projectmanagement.controller;

import com.am.projectmanagement.model.Statistics;
import com.am.projectmanagement.service.StatisticsService;
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
public class StatisticsRestController {
    private StatisticsService statisticsService;

    @Autowired
    public StatisticsRestController(StatisticsService statisticsService){
        this.statisticsService=statisticsService;
    }

    @GetMapping("/statistics/{statisticsId}")
    ResponseEntity<Statistics> getStatistics(@PathVariable Integer statisticsId){
        return ResponseEntity.of(statisticsService.getStatistics(statisticsId));
    }

    @PostMapping("/addStatistics")
    ResponseEntity<Void> createStatistics(@Valid @RequestBody Statistics statistics){
        Statistics createdStatistics = statisticsService.addStatistics(statistics);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{statisticsId}").buildAndExpand(createdStatistics.getStatisticsId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/updateStatistics/{statisticsId}")
    public ResponseEntity<Void> updateStatistics(@Valid @RequestBody Statistics statistics, @PathVariable Integer statisticsId){
        return statisticsService.getStatistics(statisticsId).map(p->{
            statisticsService.updateStatistics(statistics);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteStattistic/{statisticsId}")
    public ResponseEntity<Void> deleteStatistics(@PathVariable Integer statisticsId){
        return statisticsService.getStatistics(statisticsId).map(p->{
            statisticsService.deleteStatistics(statisticsId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/statistics")
    List<Statistics> getStatistics(){
        return statisticsService.getStatistics();
    }
}
