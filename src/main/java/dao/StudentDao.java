package dao;

import entity.Student;

import javax.persistence.EntityManager;

public class StudentDao extends AbstractJpaDao<Student,Integer> {
    public  StudentDao (EntityManager entityManager)
    {
        super(entityManager);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}
