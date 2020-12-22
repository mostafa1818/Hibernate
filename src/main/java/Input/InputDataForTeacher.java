package Input;

import entity.Student;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
@Data
public class InputDataForTeacher {
    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private long        teacherCode;
    private Double      salary;
    private Date   birthday;

    public InputDataForTeacher(long    teacherCode, Double  salary, Date birthday)
    {
        this.salary=salary;
        this.teacherCode=teacherCode;
        this.birthday=birthday;
    }
    public void addInputDataForTeacher(long    teacherCode, Double  salary, Date birthday)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("press studentCode");
        long input2 = scan.nextLong();
        this.teacherCode=input2;
        System.out.println("press salary");
        Double input3 = scan.nextDouble();
        this.salary=input3;
        System.out.println("press birthday");
        String input = scan.next();
        try {
            Data date ;
            date = (Data) dateFormat.parse(input);
            this.birthday= (Date) date;
        }catch (Exception e){}
    }

}
