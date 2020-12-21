package entity;

import lombok.Data;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.chrono.MinguoChronology;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Teacher {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int     id;
    @Column
    private String  firstName;
    @Column
    private String  lastName;
    @Column(nullable = true,unique = true)//problem
    private long    teacherCode;

    @Column( columnDefinition = " salary Double  CHECK  salary>0")

    private Double  salary;
    @Column
    private Date  birthday  ;

    @ManyToMany(mappedBy = "teacherSet")
    private Set<Student> studentSet;


    @OneToOne(mappedBy = "teacher")
    private Address address;


}
