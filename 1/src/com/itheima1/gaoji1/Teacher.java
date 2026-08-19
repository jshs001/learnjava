package com.itheima1.gaoji1;

public class Teacher extends People {
    private String skill;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void printInfo() {
        System.out.println("Teacher [name=" + getName() + ", skill=" + skill + "]");
    }
}
