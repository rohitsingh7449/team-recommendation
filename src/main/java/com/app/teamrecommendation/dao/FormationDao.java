package com.app.teamrecommendation.dao;

import com.app.teamrecommendation.model.Formation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationDao extends MongoRepository<Formation, String> {

    Formation findByMatchIdAndFormationId(String matchId, String formationId);

    List<Formation> findByMatchId(String matchId);
}
