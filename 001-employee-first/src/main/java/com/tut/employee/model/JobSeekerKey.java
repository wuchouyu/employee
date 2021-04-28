package com.tut.employee.model;

public class JobSeekerKey {
    private Integer sid;

    private Integer pid;

    public JobSeekerKey(Integer sid, Integer pid) {
        this.sid = sid;
        this.pid = pid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}