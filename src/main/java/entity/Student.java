package entity;

import lombok.Data;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Data
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
            inverseJoinColumns =@JoinColumn(name = "FK_Pro_ID"))
    private Set<Teacher> teacherSet;
}
