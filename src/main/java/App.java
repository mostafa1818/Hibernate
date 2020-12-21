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
import java.util.HashSet;
import java.util.Set;

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
        initializeDao(entityManager);
        entityManager.getTransaction().begin();
        initializeData();
        entityManager.getTransaction().commit();
        entityManager.close();
        JPAUtil.shutdown();



    }
    public static void initializeData()   {
        if(studentDao.load(CHECK_STU_ID)==null)//problem
        {
            inputBasicData=new InputBasicData( "ali","javadi");
            try {
                inputDataForTeacher=new InputDataForTeacher( 123324334,10.1,dateFormat.parse("2018/09/09") );
                } catch (ParseException e) {  System.out.println("************************************"  );e.printStackTrace(); }
            Teacher teacher1=createTeacher();
            inputBasicData=new InputBasicData( "ali","javadiyan");
            try {
                inputDataForTeacher=new InputDataForTeacher( 123324335,10.1,dateFormat.parse("2018/09/09") );
                } catch (ParseException e) {  System.out.println("************************************"  );e.printStackTrace(); }
            Teacher teacher2=createTeacher();

            inputBasicData=new InputBasicData( "masood","rahimi");
            try {
                inputDataForStudent=new InputDataForStudent( 123324333, dateFormat.parse("2018/09/09") );
                } catch (ParseException e) {  System.out.println("************************************"  );e.printStackTrace(); }
            Student student1=createStudent();
            inputBasicData=new InputBasicData( "rahim","solati");
            try {
                inputDataForStudent=new InputDataForStudent( 123324324, dateFormat.parse("2018/09/09") );
                } catch (ParseException e) {  System.out.println("************************************"  );e.printStackTrace(); }
            Student student2=createStudent();

            inputDataForAddressFirstPart=new InputDataForAddressFirstPart(22," NORTH 17shahrivar");
            inputDataForAddressSecondPart=new InputDataForAddressSecondPart("london", 123324324 ,"    Mr John Smith  132, My Street, Bigtown BG23 4YZ England");
            Address address1=createAddress();
            inputDataForAddressFirstPart=new InputDataForAddressFirstPart(23," NORTH SHAHID");
            inputDataForAddressSecondPart=new InputDataForAddressSecondPart("New York", 123324324 ,"    Mr John Smith 132, My Street, Kingston, New York 12401 United States");
            Address address2=createAddress();
            inputDataForAddressFirstPart=new InputDataForAddressFirstPart(24," south 17shahrivar");
            inputDataForAddressSecondPart=new InputDataForAddressSecondPart("london", 123324324 ,"    Mr John Smith  132, My Street, Bigtown BG23 4YZ England");
            Address address3=createAddress();
            inputDataForAddressFirstPart=new InputDataForAddressFirstPart(25," south SHAHID");
            inputDataForAddressSecondPart=new InputDataForAddressSecondPart("New York", 123324324 ,"    Mr John Smith 132, My Street, Kingston, New York 12401 United States");
            Address address4=createAddress();


            //Teacher

             Set<Student> studentSet1= new HashSet<>();
             studentSet1.add(student1);
             studentSet1.add(student1);
                 teacher1.setAddress(address1);
                 teacher1.setStudentSet(studentSet1);

             Set<Student> studentSet2= new HashSet<>();
             studentSet2.add(student2);
              studentSet2.add(student2);


                 teacher2.setAddress(address2);
                 teacher2.setStudentSet(studentSet2);





             teacherDao.save(teacher1);

             teacherDao.save(teacher2);

            //Address
            Set<Student> studentSet3= new HashSet<>();
            studentSet3.add(student1);
            studentSet3.add(student2);
            address1.setStudentSet(studentSet3);
            address1.setTeacher(teacher1);
            Set<Student> studentSet4= new HashSet<>();
            studentSet4.add(student1);
            studentSet4.add(student2);
            address2.setStudentSet(studentSet4);
            address2.setTeacher(teacher2);

            Set<Student> studentSet5= new HashSet<>();
            studentSet5.add(student1);
            studentSet5.add(student2);
            address3.setStudentSet(studentSet4);
            address3.setTeacher(teacher2);
            Set<Student> studentSet6= new HashSet<>();
            studentSet6.add(student1);
            studentSet6.add(student2);
            address4.setStudentSet(studentSet4);
            address4.setTeacher(teacher2);

            addressDao.save(address1);
            addressDao.save(address2);
            addressDao.save(address3);
            addressDao.save(address4);
             //Student
            Set<Teacher> teacherSet1= new HashSet<>();
            teacherSet1.add(teacher1);
            teacherSet1.add(teacher2);
                student1.setAddress(address2);
                student1.setTeacherSet(teacherSet1);


             Set<Teacher> teacherSet2= new HashSet<>();
             teacherSet2.add(teacher1);
             teacherSet2.add(teacher2);
                student2.setAddress(address2);
                student2.setTeacherSet(teacherSet2);


            studentDao.save(student1);

            studentDao.save(student2);









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

        return teacher;

    }
    public static Student createStudent( )
    {
        Student student=new Student();
        student.setFirstName(inputBasicData.getFirstName());
        student.setLastName(inputBasicData.getLastName());
        student.setStudentCode(inputDataForStudent.getStudentCode());
        student.setBirthday(inputDataForStudent.getBirthday());

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

         return address;

    }

    public static void initializeDao(EntityManager entityManager)
    {
        studentDao =new StudentDao(entityManager);
        teacherDao=new TeacherDao(entityManager);
        addressDao=new AddressDao(entityManager);
    }
    public static void deleteAllData(EntityManager entityManager)
    {
//        entityManager.createNamedQuery("delete from student1").executeUpdate();
//        entityManager.createNamedQuery("delete from student2").executeUpdate();
//        entityManager.createNamedQuery("delete from address1").executeUpdate();
//        entityManager.createNamedQuery("delete from address2").executeUpdate();
//        entityManager.createNamedQuery("delete from address3").executeUpdate();
//        entityManager.createNamedQuery("delete from address4").executeUpdate();
//        entityManager.createNamedQuery("delete from teacher1").executeUpdate();
//        entityManager.createNamedQuery("delete from teacher2").executeUpdate();
    }



}
