package Input;

import entity.Student;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
@Data
public class InputDataForTeacher {

    private long        teacherCode;
    private Double      salary;
    private Date   birthday;

    public InputDataForTeacher(long    teacherCode, Double  salary, Date birthday)
    {
        this.salary=salary;
        this.teacherCode=teacherCode;
        this.birthday=birthday;
    }
}
