package Input;

import lombok.Data;

import javax.persistence.Column;
@Data
public class InputBasicData {


    private String    firstName;
    private String    lastName;

        public InputBasicData(  String   firstName,String   lastName)
            {

                this.firstName=firstName;
                this.lastName=lastName;
            }
    public InputBasicData(   )
    {


    }
}
