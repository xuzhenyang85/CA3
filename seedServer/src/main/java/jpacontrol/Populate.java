package jpacontrol;

import entity.Role;
import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import security.PasswordStorage;

public class Populate
{

    public static void main(String[] args) throws PasswordStorage.CannotPerformOperationException
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_development");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
        Role userRole = new Role("User");
        Role adminRole = new Role("Admin");
        
        User user1 = new User("user1","1234");
        user1.addRole(userRole);
        em.persist(user1);

        User user2 = new User("user2","1234");
        em.persist(user2);

        em.getTransaction().commit();
        em.close();
    }
}
