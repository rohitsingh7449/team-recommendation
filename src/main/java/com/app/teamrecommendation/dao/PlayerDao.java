package com.app.teamrecommendation.dao;

import com.app.teamrecommendation.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDao extends MongoRepository<Player,String> {

}
