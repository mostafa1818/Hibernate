package Input;

import lombok.Data;

import javax.persistence.Column;
import java.util.Scanner;

@Data
public class InputDataForAddressSecondPart {


    String   city;
    String   postalAddress;
    long     postalCode;
    public InputDataForAddressSecondPart( String   city,long     postalCode,String   postalAddress)
    {
       this.city=city;
       this.postalAddress=postalAddress;
       this.postalCode=postalCode;
    }
    public void addInputDataForAddressSecondPart()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("press city");
        String input = scan.next();
        this.city=input;
        System.out.println("press postalAddress");
        input = scan.next();
        this.postalAddress=input;
        System.out.println("press postalCode");
        long input2 = scan.nextLong();
        this.postalCode=input2;
    }


}
