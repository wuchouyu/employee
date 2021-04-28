package com.tut.employee.model;

public class Company {
    private Integer cid;

    private String cname;

    private String province;

    private String caddress;

    private String contacts;

    private String phone;

    private String email;

    private String shxy;

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShxy() {
        return shxy;
    }

    public void setShxy(String shxx) {
        this.shxy = shxx;
    }

    @Override
    public String toString() {
        return "Company{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", province='" + province + '\'' +
                ", caddress='" + caddress + '\'' +
                ", contacts='" + contacts + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", shxy='" + shxy + '\'' +
                '}';
    }
}