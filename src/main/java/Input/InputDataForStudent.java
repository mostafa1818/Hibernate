package Input;

import lombok.Data;

import javax.persistence.Column;
import java.text.DateFormat;
import java.util.Date;

@Data
public class InputDataForStudent {

    private long      studentCode;
    private Date birthday;

    public InputDataForStudent( long   studentCode,Date   birthday)
    {
        this.studentCode=studentCode;
        this.birthday=birthday;
    }

}
