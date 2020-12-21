package dao;

import entity.Teacher;

import javax.persistence.EntityManager;

public class TeacherDao extends AbstractJpaDao<Teacher,Integer>{
    public  TeacherDao (EntityManager entityManager)
    {
        super(entityManager);
    }

    @Override
    public Class<Teacher> getEntityClass() {
        return Teacher.class;
    }

}
