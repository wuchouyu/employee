package com.tut.employee;

import com.github.javafaker.Faker;
import com.tut.employee.mapper.CompanyMapper;
import com.tut.employee.mapper.EmploymentMapper;
import com.tut.employee.mapper.StudentMapper;
import com.tut.employee.mapper.UserMapper;
import com.tut.employee.model.*;
import com.tut.employee.web.service.UserService;
import com.tut.employee.web.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import java.awt.print.PrinterGraphics;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Math.random;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private EmploymentMapper employmentMapper;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    public String createCname(Integer n){
        Faker fakerWithCN  = new Faker(Locale.CHINA);
        String[] firstNameArray = { "北方", "南方", "东方", "西北", "东南", "东北", "西南", "不存在", "好好玩", "有毒", "美丽大方", "天下", "太极",
                "乾坤", "饕餮", "白马", "天马","环球","寰宇","联合","天天","海洋","海燕","黑马","猛禽","伯纳","可靠","深度","红阳",
                "笑笑","六六","久久","和乐","一人","一诺","卫莱","大伟","迪克","泡泡","维诺","飞龙","不显眼","很厉害","特别的","雷诺",
                "六星","司前","童童","田夏","和马","龙凤","狂龙","大树","兔子","飞诺","兴德","好得","腾飞","小天才","神童","天涯",
                "奔腾","小马","江湖","侠客","红霞","蓝天","大地","多开心","国际","洲际","华远","华源","富力","富源","中天","众美",
                "梯度","亮眼","高光","高林","平平","非凡","巍巍","博雅","雷语","雷宇","美华","梅青","天籁","海牙","海龙","白虎",
                "青龙","龙隆","魅海","海天立","飞飞路","葱郁","萍水","丰海"};// 20个姓，其中5个复姓
        String[] lastNameArray = { "科技", "化学", "电力", "机械", "设计", "工程", "材料", "建筑", "动画", "影业", "通信", "文化",
                "建设", "金融", "船舶", "健康", "医药", "教育","医疗器械","农业","畜牧" };
        if(n< firstNameArray.length)
        return firstNameArray[n]+lastNameArray[(int)(lastNameArray.length*random())]+"有限公司";
        else
            return fakerWithCN.name().firstName()+lastNameArray[(int)(lastNameArray.length*random())]+"有限公司";
    }

    public String createEmail(){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<10;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        String[] suffix = {"@163.com","@126.com","@gmail.com","@foxmail.com","@yahoo.com"};
        return sb.toString()+suffix[(int)(suffix.length*random())];
    }

    public String createStation(){
        String[] stations = {"前端工程师","后端开发","大数据工程师","汽车机械工程师","测试开发","产品设计师","人力资源","化学工艺师"
                            };
        return null;
    }

    @Test
    public void createStudent() throws ParseException {
        Faker fakerWithCN  = new Faker(Locale.CHINA);
        String beginDate = "1998-01-01";
        String endDate = "2002-02-28";
        DateUtil dateUtil = new DateUtil();
        StudentServiceImpl studentService = new StudentServiceImpl();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0; i < 348; i++){
            Student s = new Student();
            String randomDate = dateUtil.randomDate(beginDate,endDate);
            Date date = sdf.parse(randomDate);
            s.setSname(fakerWithCN.name().fullName());
            s.setSex(s.createSex());
            s.setCollege("艺术学院");
            s.setProfession(s.createProfession(s.getCollege()));
            s.setPhone(fakerWithCN.phoneNumber().cellPhone());
            s.setSclass_(s.createSclass());
            s.setBirthday(date);
            s.setSaddress(fakerWithCN.address().state()+fakerWithCN.address().cityName()+ fakerWithCN.address().streetAddress());
            //studentMapper.insert(s);
        }

    }

    @Test
    public void Test2(){
        Faker fakerWithCN = new Faker(Locale.CHINA);
        String[] s = {"先生","女士"};
        for(Integer i = 45670502; i < 45670733; i++){
//            Company company = new Company();
//            company.setCname(createCname(i));
//            company.setContacts(fakerWithCN.name().lastName()+s[(int)(s.length*random())]);
//            company.setCaddress(fakerWithCN.address().state()+fakerWithCN.address().cityName()+ fakerWithCN.address().streetAddress());
//            company.setPhone(fakerWithCN.phoneNumber().cellPhone());
//            company.setEmail(createEmail());
            Company company = companyMapper.selectByPrimaryKey(i);
            company.setProvince(company.getCaddress().substring(0,2));
            //companyMapper.updateByPrimaryKey(company);
        }
    }

    @Test
    public void Test3(){
        Employment employment = new Employment();
        Student student = new Student();
        Company company = new Company();
        for(Integer i = 22000002; i < 22004229; i++){

//            student = studentMapper.selectByPrimaryKey(22000001+(int)(4232*random()));
//            if(student != null){
//                employment.setSid(student.getSid());
//                employment.setSclass(student.getSclass());
//                employment.setProfession(student.getProfession());
//                employment.setCollege(student.getCollege());
//                employment.setSname(student.getSname());
//                company = companyMapper.selectByPrimaryKey(45670502 + (int)(233*random()));
//                if(company != null){
//                    employment.setCid(company.getCid());
//                    employment.setCname(company.getCname());
//                    employment.setCaddress(company.getCaddress());
//                }
               employment = employmentMapper.selectByPrimaryKey(i);
                if(employment != null){
                    employment.setProvince(employment.getCaddress().substring(0,2));
                    //employmentMapper.updateByPrimaryKey(employment);
                }

            //}

        }
    }

    @Test
    public void TestCountProvince(){
        List<Map<String, Object>> list = new ArrayList<>();
        list = employmentMapper.countByProvince();
        System.out.println(list.size());
        Map<String,Integer> map = new HashMap<>();
        for (Map<String, Object> kv : list) {
            String key = null;
            Integer value = null;

            for (Map.Entry<String, Object> entry : kv.entrySet()) {
                if (entry.getKey().equals("key")) {
                    key = (String)entry.getValue();
                } else {
                    value = (Integer)entry.getValue();
                }
                map.put(key, value);
            }
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
        }
    }

    @Test
    public void TestRegister(){
        for(int i = 22000001; i < 22004234; i++){
            User user = new User();
            user.setUser_id(i);
            user.setPassword(Integer.toString(i).substring(2));
            user.setRole("USER");
            userService.addUser(user);
        }
    }
}
