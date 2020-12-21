package Input;

import lombok.Data;

import javax.persistence.Column;
import java.text.DateFormat;
@Data
public class InputDataForAddressFirstPart {


    int      number;
    String   state;

    public InputDataForAddressFirstPart(   int   number, String   state)
    {

         this.number=number;
         this.state=state;
    }
}
