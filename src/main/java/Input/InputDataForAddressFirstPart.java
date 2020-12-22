package Input;

import lombok.Data;

import javax.persistence.Column;
import java.text.DateFormat;
import java.util.Scanner;

@Data
public class InputDataForAddressFirstPart {


    int      number;
    String   state;

    public InputDataForAddressFirstPart(   int   number, String   state)
    {

         this.number=number;
         this.state=state;
    }
    public void addInputDataForAddressFirstPart()
    {

        Scanner scan = new Scanner(System.in);
        System.out.println("press number");
        int input = scan.nextInt();
        this.number=input;
        System.out.println("press state");
        String input2 = scan.next();
        this.state=input2;

    }




}
