package dao;

import entity.Address;

import javax.persistence.EntityManager;

public class AddressDao extends AbstractJpaDao<Address,Integer> {
    public AddressDao (EntityManager entityManager)
    {
        super(entityManager);
    }

    @Override
    public Class<Address> getEntityClass() {
        return Address.class;
    }

}
