package com.example.chousnthere_it.Model;

public class Classr {
    public String cname;
    public String u_id;
    public String floor;
    public String com;


    public Classr(String cname, String u_id, String floor, String com) {
        super();
        this.cname = cname;
        this.u_id = u_id;
        this.floor = floor;
        this.com = com;
    }

    public Classr(){
        super();
    }

    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getU_id() {
        return u_id;
    }
    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getFloor() {
        return floor;
    }
    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getCom() {
        return com;
    }
    public void setCom(String com) {
        this.com = com;
    }

}
