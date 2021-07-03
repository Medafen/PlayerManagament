package com.am.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.am.projectmanagement.model.Team;


public interface Team extends JpaRepository<Team,Integer> {
}
