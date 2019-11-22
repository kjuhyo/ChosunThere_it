package com.example.chousnthere_it;

public class Univ {
    public int u_id;
    public String name;

    public Univ(int u_id, String name) {
        super();
        this.u_id = u_id;
        this.name = name;
    }

    public Univ(){
        super();
    }

    public int getU_id() {
        return u_id;
    }
    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
