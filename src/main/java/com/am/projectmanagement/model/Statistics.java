package com.am.projectmanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statistics_id", nullable = false)
    private Integer statisticsId;
    @Column(name="laning", nullable = false)
    private Integer laning;
    @Column(name = "farming", nullable = false)
    private Integer farming;
    @Column(name = "pathing", nullable = false)
    private Integer pathing;
    @Column(name = "teamFighting", nullable = false)
    private Integer teamFigting;
    @Column(name = "roaming", nullable = false)
    private Integer roaming;
    @Column(name = "mapAwarness", nullable = false)
    private Integer mapAwarness;

    @OneToOne(mappedBy = "statistics")
    private Player player;

    public Integer getStatisticsId() {
        return statisticsId;
    }

    public void setStatisticsId(Integer statisticsId) {
        this.statisticsId = statisticsId;
    }

    public Integer getLaning() {
        return laning;
    }

    public void setLaning(Integer laning) {
        this.laning = laning;
    }

    public Integer getFarming() {
        return farming;
    }

    public void setFarming(Integer farming) {
        this.farming = farming;
    }

    public Integer getPathing() {
        return pathing;
    }

    public void setPathing(Integer pathing) {
        this.pathing = pathing;
    }

    public Integer getTeamFigting() {
        return teamFigting;
    }

    public void setTeamFigting(Integer teamFigting) {
        this.teamFigting = teamFigting;
    }

    public Integer getRoaming() {
        return roaming;
    }

    public void setRoaming(Integer roaming) {
        this.roaming = roaming;
    }

    public Integer getMapAwarness() {
        return mapAwarness;
    }

    public void setMapAwarness(Integer mapAwarness) {
        this.mapAwarness = mapAwarness;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
