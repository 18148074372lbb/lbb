package com.lbb.xiyu.model;

public class Order {
    private String o_id;
    private String s_id;
    private String b_id;
    private String o_starttime;
    private String o_endtime;
    private float o_money;
    private String o_status;

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getB_id() {
        return b_id;
    }

    public void setB_id(String b_id) {
        this.b_id = b_id;
    }

    public String getO_starttime() {
        return o_starttime;
    }

    public void setO_starttime(String o_starttime) {
        this.o_starttime = o_starttime;
    }

    public String getO_endtime() {
        return o_endtime;
    }

    public void setO_endtime(String o_endtime) {
        this.o_endtime = o_endtime;
    }

    public float getO_money() {
        return o_money;
    }

    public void setO_money(float o_money) {
        this.o_money = o_money;
    }

    public String getO_status() {
        return o_status;
    }

    public void setO_status(String o_status) {
        this.o_status = o_status;
    }
}
