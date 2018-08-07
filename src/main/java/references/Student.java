package references;

import java.util.Date;

public class Student {
    private int i;
    public String name;
    private Date birth;
    private String course;

    public Student(int i, String name, Date birth, String course) {
        this.i = i;
        this.name = name;
        this.birth = birth;
        this.course = course;
    }

    public Student() {
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
