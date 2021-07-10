package com.am.projectmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Integer playerId;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "nickname", nullable = false)
    private String nickname;
    @Column(name = "role", nullable = false)
    private String role;
    @Column(name = "elo", nullable = false)
    private Integer elo;


    @OneToOne
    @JsonIgnoreProperties({"statistics_id"})
    @JoinColumn(name = "statistics_id")
    private Statistics statistics;

    @ManyToOne
    @JsonIgnoreProperties({"team_id"})
    @JoinColumn(name = "team_id")
    private Team team;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getElo() {
        return elo;
    }

    public void setElo(Integer elo) {
        this.elo = elo;
    }



    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }



    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
