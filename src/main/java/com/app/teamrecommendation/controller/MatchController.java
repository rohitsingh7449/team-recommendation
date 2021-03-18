package com.app.teamrecommendation.controller;

import com.app.teamrecommendation.model.Match;
import com.app.teamrecommendation.service.MatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("matches")
public class MatchController {
    private static final Logger logger = LoggerFactory.getLogger(MatchController.class);

    @Autowired
    MatchService matchService;


    @PostMapping("/create")
    public void createMatch(@RequestBody Match match) {
        matchService.createMatch(match);
    }

    @GetMapping()
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/{matchId}")
    public Match getMatchDetails(@PathVariable String matchId) {
        return matchService.getMatchDetails(matchId);
    }

    @PutMapping("/update/{matchId}")
    public void updateMatchDetails(@PathVariable String matchId, @RequestBody Match match) {
        Match matchDB = matchService.getMatchDetails(matchId);
        if (matchDB == null) {
            logger.info("No match found for match Id : {}, Creating new Match", matchId);
            return;
        }
        matchService.updateMatchDetails(match);
    }

    @DeleteMapping()
    public void deleteAllMatches() {
        matchService.deleteAllMatches();
    }

    @DeleteMapping("/{matchId}")
    public void deleteMatch(@PathVariable String matchId) {
        matchService.deleteMatch(matchId);
    }
}
