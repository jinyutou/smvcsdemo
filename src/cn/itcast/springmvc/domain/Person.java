package cn.itcast.springmvc.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {
    private Integer id;
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
    @Size(min=3,max=10,message="用户名必须为3到10个字符!")
    private String name;
    @NotNull(message="年龄必须填写!")
    private Integer age;
    private String photoPath;
    public String getPhotoPath() {
        return photoPath;
    }
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}