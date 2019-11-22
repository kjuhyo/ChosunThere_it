package com.example.chousnthere_it;

public class Prof {
    public int id;
    public String name;
    public String call;
    public String location;
    public int u_id;

    public Prof(int id, String name, String call, String location, int u_id) {
        super();
        this.id = id;
        this.name = name;
        this.call = call;
        this.location = location;
        this.u_id = u_id;
    }

    public Prof(){
        super();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public int getU_id() {
        return u_id;
    }
    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
}
