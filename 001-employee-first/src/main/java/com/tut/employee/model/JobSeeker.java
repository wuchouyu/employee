<<<<<<< HEAD
package com.tut.employee.model;

public class JobSeeker extends JobSeekerKey {
    private Integer cid;

    private String cname;

    private String pname;

    private String sname;

    private String time;

    private String state;

    public JobSeeker(Integer sid, Integer pid){
        super(sid,pid);
    }

    public JobSeeker(Integer sid, Integer pid, Integer cid, String cname, String pname, String sname, String time, String state) {
        super(sid, pid);
        this.cid = cid;
        this.cname = cname;
        this.pname = pname;
        this.sname = sname;
        this.time = time;
        this.state = state;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "JobSeeker{" +
                "cid=" + cid +
                ", pname='" + pname + '\'' +
                ", sname='" + sname + '\'' +
                ", time='" + time + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
=======
package com.tut.employee.model;

public class JobSeeker {
    private Integer jid;

    private Integer cid;

    private Integer pid;

    private String pname;

    private Integer sid;

    private String sname;

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
>>>>>>> 78c1550c70b4444f978fe68d9918bd073881bade
}