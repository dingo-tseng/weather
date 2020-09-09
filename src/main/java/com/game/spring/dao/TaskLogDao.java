package com.game.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.spring.entity.TaskLog;



@Repository
public interface TaskLogDao extends JpaRepository<TaskLog, Long>  {

}
