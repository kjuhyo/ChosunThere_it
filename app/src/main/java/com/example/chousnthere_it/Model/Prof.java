package com.example.chousnthere_it.Model;

public class Prof {
    public String name;
    public String call;
    public String location;
    public String u_id;

    public Prof(String name, String call, String location, String u_id) {
        super();
        this.name = name;
        this.call = call;
        this.location = location;
        this.u_id = u_id;
    }

    public Prof(){
        super();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCall() {
        return call;
    }
    public void setCall(String call) {
        this.call = call;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getU_id() {
        return u_id;
    }
    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
}
