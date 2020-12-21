package entity;

import lombok.Data;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.chrono.MinguoChronology;
import java.util.Date;
import java.util.Set;


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
   // @Check(constraints = "salary > 0")
    @Column( columnDefinition = " Double  CHECK ( salary>0)")

    private Double  salary;
    @Column
    private Date  birthday  ;

    @ManyToMany(mappedBy = "teacherSet")
    private Set<Student> studentSet;


    @OneToOne(mappedBy = "teacher")
    private Address address;

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

    public long getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(long teacherCode) {
        this.teacherCode = teacherCode;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
