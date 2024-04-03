package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setName("m");
            member.setHomeAddress(new Address("city1","street","1234"));
            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");
            member.getAddressHistory().add(new AddressEntity("old1","street","1234"));
            member.getAddressHistory().add(new AddressEntity("old2","street","1234"));
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            List<AddressEntity> addressHistory = findMember.getAddressHistory();

            findMember.getHomeAddress().setCity("newCity"); //불가능
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));

            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

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
