package com.example.Basketballtelegrambot.parser;

import lombok.Getter;
import lombok.Setter;


/**
 * Parser class for future and past events
 */
@Getter @Setter
public class Event {


    private String tournament ;
    private String date;
    private String team1;
    private String team2;
    private String odd1;
    private String odd2;


    public String getTournament () {
        return tournament;
    }

    public void setTournaent (String tournament ) {
        this.tournament = tournament;
    }

    public String getDate () {
        return date ;
    }

    public void setDate (String date ) {
        this.date  = date ;
    }

    public String getTeam1() {
        return team1 ;
    }

    public void setTeam1(String team1 ) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2 ;
    }

    public void setTeam2(String team2 ) {
        this.team2 = team2;
    }

    public String getOdd1() {
        return odd1;
    }

    public void setOdd1(String odd1) {
        this.odd1 = odd1;
    }

    public String getOdd2() {
        return odd2;
    }

    public void setOdd2(String odd2) {
        this.odd2 = odd2;
    }



    @Override
    public String toString() {
        return
                "Tournament=" + tournament  +
                ", Date=" + date  +
                ", Teams=" + team1  +
                ", Win1=" + odd1  +
                ", Win2=" + odd2;
    }



}
