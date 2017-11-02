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
        
        User adminUser = new User("adminUser","1234");
        adminUser.addRole(adminRole);
        em.persist(adminUser);
    
        User user2 = new User("user2","1234");
        user2.addRole(userRole);
        em.persist(user2);
        
        User user3 = new User("user3","1234");
        user3.addRole(userRole);
        em.persist(user3);
        
        User user4 = new User("user4","1234");
        user4.addRole(userRole);
        em.persist(user4);
        
        em.getTransaction().commit();
        em.close();
    }
}
