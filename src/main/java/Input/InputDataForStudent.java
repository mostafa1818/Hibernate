package Input;

import lombok.Data;

import javax.persistence.Column;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Data
public class InputDataForStudent {
    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private long      studentCode;
    private Date birthday;

    public InputDataForStudent( long   studentCode,Date   birthday)
    {
        this.studentCode=studentCode;
        this.birthday=birthday;
    }
    public void addInputDataForStudent()  {
        Scanner scan = new Scanner(System.in);


        System.out.println("press studentCode");
        long input2 = scan.nextLong();
        this.studentCode=input2;
        System.out.println("press birthday");
        String input = scan.next();

        try {
            Data date ;
            date = (Data) dateFormat.parse(input);
            this.birthday= (Date) date;
        }catch (Exception e){}

    }

}
