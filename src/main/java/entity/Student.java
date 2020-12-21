package entity;

import lombok.Data;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int       id;
    @Column
    private String    firstName;
    @Column
    private String    lastName;
    @Column
    private long      studentCode;
    @Column
    private Date  birthday  ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "fk_address",nullable = false)
    private Address address;

    @ManyToMany
    @JoinTable(name = "Stu_Pro", joinColumns =@JoinColumn (name = "fk_Stu_ID"),
            inverseJoinColumns =@JoinColumn(name = "FK_Tec_ID"))
    private Set<Teacher> teacherSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(long studentCode) {
        this.studentCode = studentCode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Teacher> getTeacherSet() {
        return teacherSet;
    }

    public void setTeacherSet(Set<Teacher> teacherSet) {
        this.teacherSet = teacherSet;
    }
}
