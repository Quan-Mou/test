package com.quan.spring.transaction.entify;


public class Account {

    private Integer actno;
    private String act_name;

    private Double balance;

    public Account(Integer actno, String act_name, Double balance) {
        this.actno = actno;
        this.act_name = act_name;
        this.balance = balance;
    }

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "actno=" + actno +
                ", act_name='" + act_name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Integer getActno() {
        return actno;
    }

    public void setActno(Integer actno) {
        this.actno = actno;
    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
