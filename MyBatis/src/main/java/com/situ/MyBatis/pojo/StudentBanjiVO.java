package com.situ.MyBatis.pojo;

public class StudentBanjiVO {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Integer banjiId;
    private String banjiName;

    public StudentBanjiVO() {
    }

    public StudentBanjiVO(Integer id, String name, Integer age, String gender, Integer banjiId, String banjiName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.banjiId = banjiId;
        this.banjiName = banjiName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getBanjiId() {
        return banjiId;
    }

    public void setBanjiId(Integer banjiId) {
        this.banjiId = banjiId;
    }

    public String getBanjiName() {
        return banjiName;
    }

    public void setBanjiName(String banjiName) {
        this.banjiName = banjiName;
    }

    @Override
    public String toString() {
        return "StudentBanjiVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", banjiId=" + banjiId +
                ", banjiName='" + banjiName + '\'' +
                '}';
    }
}
