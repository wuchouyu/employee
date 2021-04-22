package com.tut.employee.model;

public class Position {
    private Integer pid;

    private Integer cid;

    private String cname;

    private String name;

    private String salary;

    private String education;

    private String profession;

    private String detail;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Position{" +
                "pid=" + pid +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", education='" + education + '\'' +
                ", profession='" + profession + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}