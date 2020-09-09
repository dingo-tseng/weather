package com.game.spring.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.cglib.core.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.game.spring.entity.WeatherInfo;
import com.game.spring.entity.WeatherInfoMultiKeysClass;

@Repository
public interface WeatherInfoDao extends JpaRepository<WeatherInfo, WeatherInfoMultiKeysClass>,JpaSpecificationExecutor<WeatherInfo> {
	//錯誤代碼public WeatherInfo findByUsernameAndPassword(String Username, String Password);

}
