package com.example.studentsmanagement.model;


import javax.persistence.*;

@Entity(name = "student")
public class Student {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.AUTO) //把Hibernate提供的主键生成策略设置为identity(即自增）
    private Long id;

    @Column(nullable = false, name = "name") //限制：不能为null column的名字
    private String name;

    @ManyToOne
    @JoinColumn(name = "university_class_id")
    private UniversityClass universityClass;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UniversityClass getUniversityClass() {
        return universityClass;
    }

    public void setUniversityClass(UniversityClass universityClass) {
        this.universityClass = universityClass;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Primary ID: " + getId();
        str += " Name: " + getName();
        return str;
    }
}
