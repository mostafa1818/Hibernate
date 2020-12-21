package Input;

import lombok.Data;

import javax.persistence.Column;
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


}
