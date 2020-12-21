import Input.*;
import dao.AddressDao;
import dao.StudentDao;
import dao.TeacherDao;
import entity.Address;
import entity.Student;
import entity.Teacher;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {


    private static InputBasicData inputBasicData;
    private static InputDataForAddressFirstPart  inputDataForAddressFirstPart;
    private static InputDataForAddressSecondPart inputDataForAddressSecondPart;
    private static InputDataForStudent inputDataForStudent;
    private static InputDataForTeacher inputDataForTeacher;
    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static StudentDao studentDao;
    private static AddressDao addressDao;
    private static TeacherDao teacherDao;
    private static final Integer CHECK_STU_ID=2;//problem
    private static final Integer CHECK_TEC_ID=1;//problem
    private static final Integer CHECK_ADR_ID=1;//problem



    public static void main(String[] args)
    {
        EntityManager entityManager= JPAUtil.getEntityManagerFactory().createEntityManager();


    }
    public static void initializeDate() throws ParseException {
        if(studentDao.load(CHECK_STU_ID)==null)//problem
        {
            inputBasicData=new InputBasicData( "ali","javadi");
            inputDataForTeacher=new InputDataForTeacher( 123324334,10.1,dateFormat.parse("2018/09/09") );
            Teacher teacher1=createTeacher();
            inputBasicData=new InputBasicData( "ali","javadiyan");
            inputDataForTeacher=new InputDataForTeacher( 123324335,10.1,dateFormat.parse("2018/09/09") );
            Teacher teacher2=createTeacher();

            inputBasicData=new InputBasicData( "masood","rahimi");
            inputDataForStudent=new InputDataForStudent( 123324333, dateFormat.parse("2018/09/09") );
            Student student1=createStudent();
            inputBasicData=new InputBasicData( "rahim","solati");
            inputDataForStudent=new InputDataForStudent( 123324324, dateFormat.parse("2018/09/09") );
            Student student2=createStudent();

            inputDataForAddressFirstPart=new InputDataForAddressFirstPart(22," NORTH 17shahrivar");
            inputDataForAddressSecondPart=new InputDataForAddressSecondPart("london", 123324324 ,"    Mr John Smith  132, My Street, Bigtown BG23 4YZ England");
            Address address1=createAddress();
            inputDataForAddressFirstPart=new InputDataForAddressFirstPart(22," NORTH SHAHID");
            inputDataForAddressSecondPart=new InputDataForAddressSecondPart("New York", 123324324 ,"    Mr John Smith 132, My Street, Kingston, New York 12401 United States");
            Address address2=createAddress();

            //add set
            //Teacher
                teacher1.setAddress(address1);
                teacher2.setAddress(address2);

            //Student


            //Address


        }
    }
    public static Teacher createTeacher( )
    {
        Teacher teacher=new Teacher();
        teacher.setFirstName(inputBasicData.getFirstName());
        teacher.setLastName(inputBasicData.getLastName());
        teacher.setSalary(inputDataForTeacher.getSalary());
        teacher.setTeacherCode(inputDataForTeacher.getTeacherCode());
        teacher.setBirthday(inputDataForTeacher.getBirthday());
        teacherDao.save(teacher);
        return teacher;

    }
    public static Student createStudent( )
    {
        Student student=new Student();
        student.setFirstName(inputBasicData.getFirstName());
        student.setLastName(inputBasicData.getLastName());
        student.setStudentCode(inputDataForStudent.getStudentCode());
        student.setBirthday(inputDataForStudent.getBirthday());
        studentDao.save(student);
        return student;

    }

    public static Address createAddress()
    {
        Address address=new Address();
         address.setNumber(inputDataForAddressFirstPart.getNumber());
         address.setState(inputDataForAddressFirstPart.getState());
         address.setCity(inputDataForAddressSecondPart.getCity());
         address.setPostalCode(inputDataForAddressSecondPart.getPostalCode());
         address.setPostalAddress(inputDataForAddressSecondPart.getPostalAddress());
         addressDao.save(address);
         return address;



    }


}
