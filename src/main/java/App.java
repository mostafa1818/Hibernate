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
    private static Student[] students =new Student[10];
    private static Address[] addresses=new Address[10];
    private static Teacher[] teachers= new Teacher[10];
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
        inputBasicData=new InputBasicData( "ali","javadiyan");

          deleteData( entityManager );
       // deleteAllData(entityManager);
        //   updateData( entityManager );
         showData( entityManager );


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

            } catch (ParseException e) {  e.printStackTrace(); }
            teachers[0]=createTeacher();
            inputBasicData=new InputBasicData( "ali","javadiyan");
            try {
                inputDataForTeacher=new InputDataForTeacher( 123324335,10.1,dateFormat.parse("2018/09/09") );
                } catch (ParseException e) {   e.printStackTrace(); }
            teachers[1]=createTeacher();

            inputBasicData=new InputBasicData( "masood","rahimi");
            try {
                inputDataForStudent=new InputDataForStudent( 123324333, dateFormat.parse("2018/09/09") );
                } catch (ParseException e) {  e.printStackTrace(); }
             students[0]=createStudent();
            inputBasicData=new InputBasicData( "rahim","solati");
            try {
                inputDataForStudent=new InputDataForStudent( 123324324, dateFormat.parse("2018/09/09") );
                } catch (ParseException e) { e.printStackTrace(); }
            students[1]=createStudent();

            inputDataForAddressFirstPart=new InputDataForAddressFirstPart(22," NORTH 17shahrivar");
            inputDataForAddressSecondPart=new InputDataForAddressSecondPart("london", 123324324 ,"    Mr John Smith  132, My Street, Bigtown BG23 4YZ England");
                addresses[0]=createAddress();
            inputDataForAddressFirstPart=new InputDataForAddressFirstPart(23," NORTH SHAHID");
            inputDataForAddressSecondPart=new InputDataForAddressSecondPart("New York", 123324324 ,"    Mr John Smith 132, My Street, Kingston, New York 12401 United States");
                addresses[1]=createAddress();
            inputDataForAddressFirstPart=new InputDataForAddressFirstPart(24," south 17shahrivar");
            inputDataForAddressSecondPart=new InputDataForAddressSecondPart("london", 123324324 ,"    Mr John Smith  132, My Street, Bigtown BG23 4YZ England");
                addresses[2]=createAddress();
            inputDataForAddressFirstPart=new InputDataForAddressFirstPart(25," south SHAHID");
            inputDataForAddressSecondPart=new InputDataForAddressSecondPart("New York", 123324324 ,"    Mr John Smith 132, My Street, Kingston, New York 12401 United States");
                addresses[3]=createAddress();


            //Teacher

             Set<Student> studentSet1= new HashSet<>();
             studentSet1.add(students[0]);
             studentSet1.add(students[0]);

                   teachers[0].setAddress(addresses[0]);
                   teachers[0].setStudentSet(studentSet1);



             Set<Student> studentSet2= new HashSet<>();
             studentSet2.add(students[1]);
             studentSet2.add(students[1]);

                 teachers[1].setAddress(addresses[1]);
                 teachers[1].setStudentSet(studentSet2);

                    teacherDao.save(teachers[0]);
                    teacherDao.save(teachers[1]);

            //Address
            Set<Student> studentSet3= new HashSet<>();
            studentSet3.add(students[0]);
            studentSet3.add(students[1]);
                addresses[0].setStudentSet(studentSet3);
                addresses[0].setTeacher(teachers[0]);

            Set<Student> studentSet4= new HashSet<>();
            studentSet4.add(students[0]);
            studentSet4.add(students[1]);
                addresses[1].setStudentSet(studentSet4);
                addresses[1].setTeacher(teachers[1]);

            Set<Student> studentSet5= new HashSet<>();
            studentSet5.add(students[0]);
            studentSet5.add(students[1]);
                addresses[2].setStudentSet(studentSet5);
                addresses[2].setTeacher(teachers[1]);
            Set<Student> studentSet6= new HashSet<>();
            studentSet6.add(students[0]);
            studentSet6.add(students[1]);
                addresses[3].setStudentSet(studentSet6);
                addresses[3].setTeacher(teachers[1]);

                addressDao.save(addresses[0]);
                addressDao.save(addresses[1]);
                addressDao.save(addresses[2]);
                addressDao.save(addresses[3]);

             //Student
            Set<Teacher> teacherSet1= new HashSet<>();
            teacherSet1.add(teachers[0]);
            teacherSet1.add(teachers[1]);
                students[0].setAddress(addresses[1]);
                students[0].setTeacherSet(teacherSet1);


             Set<Teacher> teacherSet2= new HashSet<>();
             teacherSet2.add(teachers[0]);
             teacherSet2.add(teachers[1]);
                students[1].setAddress(addresses[1]);
                students[1].setTeacherSet(teacherSet2);


                studentDao.save(students[0]);
                studentDao.save(students[1]);


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
   //      entityManager.createNamedQuery("delete from student[1]").executeUpdate();
//        entityManager.createNamedQuery("delete from student2").executeUpdate();
//        entityManager.createNamedQuery("delete from address1").executeUpdate();
//        entityManager.createNamedQuery("delete from address2").executeUpdate();
//        entityManager.createNamedQuery("delete from address3").executeUpdate();
//        entityManager.createNamedQuery("delete from address4").executeUpdate();
//        entityManager.createNamedQuery("delete from teacher1").executeUpdate();
//        entityManager.createNamedQuery("delete from teacher2").executeUpdate();
    }
    public static   void  deleteData(EntityManager entityManager )
    {
        Address newAddress=  addressDao.load(4);
      try {
          addressDao.delete( newAddress);
      }catch (Exception e){}

        System.out.println("************************************llllllllllllllllll\n"  );


    }
    public static   void  updateData(EntityManager entityManager )
    {
        inputDataForAddressFirstPart=new InputDataForAddressFirstPart(36," south SHAHID");
        inputDataForAddressSecondPart=new InputDataForAddressSecondPart("New York1", 123324324 ,"    Mr John Smith 132, My Street, Kingston, New York 12401 United States");

        addresses[4]=createAddress();
        Set<Student> studentSet6= new HashSet<>();
        studentSet6.add(students[0]);
        studentSet6.add(students[1]);
        addresses[4].setId(2);
        addresses[4].setStudentSet(studentSet6);
        addresses[4].setTeacher(teachers[1]);

        addressDao.update(addresses[2]);
    }
    public static <T>  void  showData(EntityManager entityManager )
    {
        Address newAddress=  addressDao.load(4);
        Address newAddress2=  addressDao.load(3);
        Address newAddress3=  addressDao.load(2);
        Address newAddress4=  addressDao.load(1);
        Student newStudent=  studentDao.load(1);
        Teacher newTeacher=  teacherDao.load(1);

        try {
            System.out.println("************************************\n");
            System.out.println(" Id= " + newAddress.getId() + "  Number= " + newAddress.getNumber() + "  City= " + newAddress.getCity());
        }catch (Exception e){}
        System.out.println("************************************\n"  );
        System.out.println("************************************\n"  );
        System.out.println(" Id= "+newAddress2.getId()+"  Number= "+newAddress2.getNumber()+"  City= "+newAddress2.getCity());


        System.out.println("************************************\n"  );
        System.out.println("************************************\n"  );
        System.out.println(" Id= "+newAddress3.getId()+"  Number= "+newAddress3.getNumber()+"  City= "+newAddress3.getCity());
        System.out.println("************************************\n"  );
        System.out.println("************************************\n"  );
        System.out.println(" Id= "+newAddress4.getId()+"  Number= "+newAddress4.getNumber()+"  City= "+newAddress4.getCity());
        System.out.println("************************************\n"  );
        System.out.println("************************************\n"  );


        System.out.println(" Id= "+newTeacher.getId()+"  FirstName= "+newTeacher.getFirstName()+"  LastName= "+newTeacher.getLastName());
        System.out.println("************************************\n"  );
        System.out.println("************************************\n"  );
        System.out.println(" Id= "+newStudent.getId()+"  FirstName= "+newStudent.getFirstName()+"  LastName= "+newStudent.getLastName());
        System.out.println("************************************\n"  );
    }



}
