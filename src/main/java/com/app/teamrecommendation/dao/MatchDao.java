package com.app.teamrecommendation.dao;

import com.app.teamrecommendation.model.Match;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchDao extends MongoRepository<Match,String> {
}
