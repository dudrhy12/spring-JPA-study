package jpql;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
        Member member = new Member();
        member.setUsername("영서");
        em.persist(member);
        em.flush();
        em.clear();

        List resultList = em.createQuery("select m.username, m.age from Member m")
                .getResultList();

        Object o = resultList.get(0);
        Object[] result = (Object[]) 0;
        System.out.println("result"+result[0]);
        System.out.println("result"+result[1]);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }

}
