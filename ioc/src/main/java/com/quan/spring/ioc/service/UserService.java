package com.quan.spring.ioc.service;



import com.quan.spring.ioc.bean.Goods;
import com.quan.spring.ioc.bean.House;
import com.quan.spring.ioc.bean.User;

import java.util.Arrays;
import java.util.Map;

public class UserService {



    private String[] aiHao;

    private Goods[] good;

    private Map<String,String> friends;
    private Map<String, House> house;

    private User user;

    public void setUser(User user) {
        this.user = user;
    }



    @Override
    public String toString() {
        return "UserService{" +
                "aiHao=" + Arrays.toString(aiHao) +
                ", good=" + Arrays.toString(good) +
                ", friends=" + friends +
                ", house=" + house +
                ", user=" + user +
                '}';
    }

    public UserService() {
        System.out.println("UserService 无参构造执行了");
    }
    public UserService(String[] aiHao) {
        this.aiHao = aiHao;
    }

    public UserService(String[] aiHao, Goods[] good, Map<String, String> friends, Map<String, House> house) {
        this.aiHao = aiHao;
        this.good = good;
        this.friends = friends;
        this.house = house;
    }

    public void setHouse(Map<String, House> house) {
        this.house = house;
    }

    public void setFriends(Map<String, String> friends) {
        this.friends = friends;
    }

    public void setAiHao(String[] aiHao) {
        this.aiHao = aiHao;
    }

    public void setGood(Goods[] good) {
        this.good = good;
    }

}
