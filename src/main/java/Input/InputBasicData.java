package Input;

import lombok.Data;

import javax.persistence.Column;
import java.util.Scanner;

@Data
public class InputBasicData {


    private String    firstName;
    private String    lastName;

        public InputBasicData(  String   firstName,String   lastName)
            {

                this.firstName=firstName;
                this.lastName=lastName;
            }

    public void addInputBasicData()
    {

        Scanner scan = new Scanner(System.in);
        System.out.println("press first name");
        String input = scan.next();
        this.firstName=input;
        System.out.println("press last name");
        input = scan.next();
        this.lastName=input;

    }
}
