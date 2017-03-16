package com.newlecture.web.data.entity;

import java.sql.Date;

public class Member2 {
   private String mid;
   private String pwd;
   private String name;
   private String gender;
   private int age;
   private String birthday;
   private String major;
   private String address;
   private String phone;
   private String ssn;
   private String ip;
   private Date   regDate;
   
   public String getMid() {
      return mid;
   }
   public void setMid(String mid) {
      this.mid = mid;
   }
   public String getPwd() {
      return pwd;
   }
   public void setPwd(String pwd) {
      this.pwd = pwd;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getGender() {
      return gender;
   }
   public void setGender(String gender) {
      this.gender = gender;
   }
   public int getAge() {
      return age;
   }
   public void setAge(int age) {
      this.age = age;
   }
   public String getBirthday() {
      return birthday;
   }
   public void setBirthday(String birthday) {
      this.birthday = birthday;
   }
   public String getMajor() {
      return major;
   }
   public void setMajor(String major) {
      this.major = major;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   public String getPhone() {
      return phone;
   }
   public void setPhone(String phone) {
      this.phone = phone;
   }
   public String getSsn() {
      return ssn;
   }
   public void setSsn(String ssn) {
      this.ssn = ssn;
   }
   public String getIp() {
      return ip;
   }
   public void setIp(String ip) {
      this.ip = ip;
   }
   public Date getRegDate() {
      return regDate;
   }
   public void setRegDate(Date regDate) {
      this.regDate = regDate;
   }
   
   
   
}