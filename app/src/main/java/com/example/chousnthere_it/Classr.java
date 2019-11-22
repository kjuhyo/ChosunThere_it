package com.example.chousnthere_it;

public class Classr {
    public String cid;
    public String cname;
    public int u_id;
    public int com;

    public Classr(String cid, String cname, int u_id, int com) {
        super();
        this.cid = cid;
        this.cname = cname;
        this.u_id = u_id;
        this.com = com;
    }

    public Classr(){
        super();
    }

    public String getCid() {
        return cid;
    }
    public void setCid(String cid) {
        this.cid = cid;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public int getU_id() {
        return u_id;
    }
    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
    public int getCom() {
        return com;
    }
    public void setCom(int com) {
        this.com = com;
    }
}
