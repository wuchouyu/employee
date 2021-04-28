package com.tut.employee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.javafaker.Faker;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

import static java.lang.Math.random;

public class Student {
    private Integer sid;

    private String sname;

    private String saddress;

    private String college;

    private String profession;

    private String phone;

    private String sex;

    private String sclass;

    private String id;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer id) {
        this.sid = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String name) {
        this.sname = name;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String address) {
        this.saddress = address;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass_(String sclass) {
        this.sclass = sclass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String createSclass() {
        String[] classes = {"1班","2班","3班","4班"};
        int classesPos = (int) (4 * random());
        return classes[classesPos];
    }

    public String createCollege(){
        String[] colleges = {"机械工程学院","管理学院","计算机科学与工程学院","材料科学与工程学院",
        "电子电气工程学院","化学化工学院","理学院","艺术学院","海运学院","环境科学与安全工程学院"};
        int collegesPos = (int) (10 * random());
        return colleges[collegesPos];
    }

    public String createProfession(String college){
        Map<String, String[]> professions = new HashMap<>();
        String profession = null;
        String[] jx = {"过程装备与控制工程","机械电子工程"};
        String[] gl = {"工程造价","工商管理","财务管理","市场营销","保险学"};
        String[] jsj = {"计算机科学与技术","信息安全","物联网","计算科学"};
        String[] cl = {"材料科学与工程","材料成型及控制工程","材料物理","新能源材料与器件"};
        String[] dd = {"电子工程及其自动化","电子信息工程","电子科学与技术","通行工程"};
        String[] hx = {"制药工程","化学工程与工艺","应用化学"};
        String[] l = {"数学与应用数学","应用物理学"};
        String[] ys = {"产品设计","环境艺术设计","摄影"};
        String[] hy = {"航海技术","轮机工程","船舶电子电气工程"};
        String[] hj = {"环境科学","安全工程","环境工程"};
        professions.put("机械工程学院",jx);
        professions.put("管理学院",gl);
        professions.put("计算机科学与工程学院",jsj);
        professions.put("材料科学与工程学院",cl);
        professions.put("电子电气工程学院",dd);
        professions.put("化学化工学院",hx);
        professions.put("理学院",l);
        professions.put("艺术学院",ys);
        professions.put("海运学院",hy);
        professions.put("环境科学与安全工程学院",hj);

        for(Map.Entry<String, String[]> entry : professions.entrySet()){
            if(college.equals(entry.getKey())){
                String[] temp = entry.getValue();
                profession = temp[(int)(temp.length * random())];
                break;
            }
        }
        return profession;
    }

    public String createSex(){
        String[] sex = {"男","女"};
        return sex[(int)(sex.length*random())];
    }


    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", saddress='" + saddress + '\'' +
                ", college='" + college + '\'' +
                ", profession='" + profession + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", sclass='" + sclass + '\'' +
                ", id='" + id + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
