package entity;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int      id;
    @Column(nullable = true,unique = true)//problem
    int      number;
    @Column
    String   state;
    @Column
    String   city;
    @Column
    String   postalAddress;
    @Column
    Long     postalCode;




    @OneToMany(mappedBy = "address")
    private Set<Student> studentSet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;


}
