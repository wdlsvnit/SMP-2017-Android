package com.codehash.nikunj.ACMChallenge;

/**
 * Created by nikunj on 6/6/17.
 */

public class Datas {
    public String username,profile,name,problems_solved,time_taken;
    int score,rank;
    public Datas(String username,String profile,String name,String problems_solved,String time_taken,int score,int rank)
    {
        this.username=username;
        this.profile=profile;
        this.name=name;
        this.problems_solved=problems_solved;
        this.time_taken=time_taken;
        this.score=score;
        this.rank=rank;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProblems_solved() {
        return problems_solved;
    }

    public void setProblems_solved(String problems_solved) {
        this.problems_solved = problems_solved;
    }

    public String getTime_taken() {
        return time_taken;
    }

    public void setTime_taken(String time_taken) {
        this.time_taken = time_taken;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
