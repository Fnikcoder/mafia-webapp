package com.first.firstspringbootproject.player;

import com.google.cloud.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Map;

@Entity
@Table
public class Player {

    private Long chat_id;
    private String nickname;
    private Integer win_total_num;
    private Integer played_games_num;

    private Integer win_mafia_num;
    private Integer got_silver_num;
    private Integer got_role_mostaghel_num;
    private Integer win_citizen_num;
    private Integer average_win_total;
    private Integer got_bronze_num;
    private Integer got_gold_num;
    private Integer win_mostaghel_num;
    private Timestamp last_active_time;
    private Integer ranking_place;
    private Integer got_role_citizen_num;
    private Integer got_role_mafia_num;
    private String username;
    private String name;
    private Map<String, Integer> got_roles;


    public Player() {
        // no-argument constructor
    }

    public Player(Long chat_id, String nickname, Integer win_total_num, Integer played_games_num, Integer win_mafia_num,
                  Integer got_silver_num, Integer got_role_mostaghel_num, Integer win_citizen_num,
                  Integer average_win_total, Integer got_bronze_num, Integer got_gold_num, Integer win_mostaghel_num,
                  Timestamp last_active_time, Integer ranking_place, Integer got_role_citizen_num,
                  Integer got_role_mafia_num, String username, String name, Map<String, Integer> got_roles) {
        this.chat_id = chat_id;
        this.nickname = nickname;
        this.win_total_num = win_total_num;
        this.played_games_num = played_games_num;
        this.win_mafia_num = win_mafia_num;
        this.got_silver_num = got_silver_num;
        this.got_role_mostaghel_num = got_role_mostaghel_num;
        this.win_citizen_num = win_citizen_num;
        this.average_win_total = average_win_total;
        this.got_bronze_num = got_bronze_num;
        this.got_gold_num = got_gold_num;
        this.win_mostaghel_num = win_mostaghel_num;
        this.last_active_time = last_active_time;
        this.ranking_place = ranking_place;
        this.got_role_citizen_num = got_role_citizen_num;
        this.got_role_mafia_num = got_role_mafia_num;
        this.username = username;
        this.name = name;
        this.got_roles = got_roles;
    }

    @Override
    public String toString() {
        return "Player{" +
                "chat_id=" + chat_id +
                ", nickname='" + nickname + '\'' +
                ", win_total_num=" + win_total_num +
                ", played_games_num=" + played_games_num +
                ", win_mafia_num=" + win_mafia_num +
                ", got_silver_num=" + got_silver_num +
                ", got_role_mostaghel_num=" + got_role_mostaghel_num +
                ", win_citizen_num=" + win_citizen_num +
                ", average_win_total=" + average_win_total +
                ", got_bronze_num=" + got_bronze_num +
                ", got_gold_num=" + got_gold_num +
                ", win_mostaghel_num=" + win_mostaghel_num +
                ", last_active_time=" + last_active_time +
                ", ranking_place=" + ranking_place +
                ", got_role_citizen_num=" + got_role_citizen_num +
                ", got_role_mafia_num=" + got_role_mafia_num +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", got_roles=" + got_roles +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getGot_roles() {
        return got_roles;
    }

    public void setGot_roles(Map<String, Integer> got_roles) {
        this.got_roles = got_roles;
    }

    public Long getChat_id() {
        return chat_id;
    }

    public void setChat_id(Long chat_id) {
        this.chat_id = chat_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getWin_total_num() {
        return win_total_num;
    }

    public void setWin_total_num(Integer win_total_num) {
        this.win_total_num = win_total_num;
    }

    public Integer getPlayed_games_num() {
        return played_games_num;
    }

    public void setPlayed_games_num(Integer played_games_num) {
        this.played_games_num = played_games_num;
    }

    public Integer getWin_mafia_num() {
        return win_mafia_num;
    }

    public void setWin_mafia_num(Integer win_mafia_num) {
        this.win_mafia_num = win_mafia_num;
    }

    public Integer getGot_silver_num() {
        return got_silver_num;
    }

    public void setGot_silver_num(Integer got_silver_num) {
        this.got_silver_num = got_silver_num;
    }

    public Integer getGot_role_mostaghel_num() {
        return got_role_mostaghel_num;
    }

    public void setGot_role_mostaghel_num(Integer got_role_mostaghel_num) {
        this.got_role_mostaghel_num = got_role_mostaghel_num;
    }

    public Integer getWin_citizen_num() {
        return win_citizen_num;
    }

    public void setWin_citizen_num(Integer win_citizen_num) {
        this.win_citizen_num = win_citizen_num;
    }

    public Integer getAverage_win_total() {
        return average_win_total;
    }

    public void setAverage_win_total(Integer average_win_total) {
        this.average_win_total = average_win_total;
    }

    public Integer getGot_bronze_num() {
        return got_bronze_num;
    }

    public void setGot_bronze_num(Integer got_bronze_num) {
        this.got_bronze_num = got_bronze_num;
    }

    public Integer getGot_gold_num() {
        return got_gold_num;
    }

    public void setGot_gold_num(Integer got_gold_num) {
        this.got_gold_num = got_gold_num;
    }

    public Integer getWin_mostaghel_num() {
        return win_mostaghel_num;
    }

    public void setWin_mostaghel_num(Integer win_mostaghel_num) {
        this.win_mostaghel_num = win_mostaghel_num;
    }

    public Timestamp getLast_active_time() {
        return last_active_time;
    }

    public void setLast_active_time(Timestamp last_active_time) {
        this.last_active_time = last_active_time;
    }

    public Integer getRanking_place() {
        return ranking_place;
    }

    public void setRanking_place(Integer ranking_place) {
        this.ranking_place = ranking_place;
    }

    public Integer getGot_role_citizen_num() {
        return got_role_citizen_num;
    }

    public void setGot_role_citizen_num(Integer got_role_citizen_num) {
        this.got_role_citizen_num = got_role_citizen_num;
    }

    public Integer getGot_role_mafia_num() {
        return got_role_mafia_num;
    }

    public void setGot_role_mafia_num(Integer got_role_mafia_num) {
        this.got_role_mafia_num = got_role_mafia_num;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
