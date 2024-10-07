package com.crio.coderhack.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Builder
@Document

public class UserEntity {
    @Id
    private String userId;
    private String userName;

    private int score;
    Set<String> badges = new HashSet<>();

//    public UserEntity(String username) {
//        this.userName = username;
//        this.score = 0;
//        this.badges = new HashSet<>();
//    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        updateBadgesBasedOnScore();
    }

    public Set<String> getBadges() {
        return badges;
    }

    public void setBadges(Set<String> badges) {
        this.badges = badges;
    }
    private void updateBadgesBasedOnScore() {
        if (score >= 1 && score < 30) {
            badges.add("Code Ninja");
        }
        if (score >= 30 && score < 60) {
            badges.add("Code Champ");
        }
        if (score >= 60 && score <= 100) {
            badges.add("Code Master");
        }
    }


}
