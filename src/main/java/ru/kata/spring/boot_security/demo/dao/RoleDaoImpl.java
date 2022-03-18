package ru.kata.spring.boot_security.demo.dao;


import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }


    @Override
    public Role getRoleByName(String name) {
        Role role = null;
        try {
            role = getEntityManager().createQuery("SELECT r FROM Role r WHERE r.role=:name", Role.class)
                    .setParameter("name", name)
                    .getSingleResult();

        } catch (Exception e) {
            System.out.println("Роли с таким именем не существует!");
        }
        return role;
    }

    @Override
    public Role getRoleById(int id) {
        return getEntityManager().find(Role.class, id);
    }

}
