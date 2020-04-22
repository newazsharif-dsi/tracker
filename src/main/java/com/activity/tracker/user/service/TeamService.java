package com.activity.tracker.user.service;

import com.activity.tracker.model.Team;
import com.activity.tracker.user.dao.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamDao teamDao;


    public List<Team> getAllTeams() {
        return teamDao.getAllTeams();
    }

}
