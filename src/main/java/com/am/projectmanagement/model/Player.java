package com.am.projectmanagement.model;

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
    @Column(name = "isJungler", nullable = false)
    private Boolean isJungler;

    @OneToOne
    @JoinColumn(name = "statistics_id")
    private Statistics statistics;

    @ManyToOne
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

    public Boolean getJungler() {
        return isJungler;
    }

    public void setJungler(Boolean jungler) {
        isJungler = jungler;
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
