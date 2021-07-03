package com.am.projectmanagement.repository;

import com.am.projectmanagement.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamRepository extends JpaRepository<Team,Integer> {
}
