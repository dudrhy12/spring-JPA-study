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
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();

            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);


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
