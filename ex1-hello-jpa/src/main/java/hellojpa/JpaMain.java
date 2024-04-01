package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member1 = new Member();
            member1.setName("bella1");
            em.persist(member1);

            Member member2 = new Member();
            member2.setName("bella2");
            em.persist(member2);

            em.flush();
            em.clear();

            Member reference1 = em.getReference(Member.class, member1.getId());
            System.out.println("reference1="+reference1.getClass()); //proxy

            System.out.println("isLoaded="+emf.getPersistenceUnitUtil().isLoaded(reference1));
            System.out.println("reference1="+reference1.getClass());
            Hibernate.initialize(reference1);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(Member m1, Member m3) { //실제 비교되는 사례, 프록시로 넘어올지 엔티티로 넘어올지 모른다.
        System.out.println("m1 == m3"+ (m1 instanceof Member)); //true
        System.out.println("m1 == m3"+ (m3 instanceof Member)); //true
    }

    private static void printMember(Member member) {
        System.out.println("member=" + member.getName());
    }
    private static void printMemberAndTeam(Member member){
        String username = member.getName();
        System.out.println("username="+username);
        Team team = member.getTeam();
        System.out.println("team="+team.getName());
    }
}
