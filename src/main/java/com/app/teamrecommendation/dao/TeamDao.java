package com.app.teamrecommendation.dao;

import com.app.teamrecommendation.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDao extends MongoRepository<Team, String> {

}
