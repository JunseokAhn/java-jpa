import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction TR = EM.getTransaction();
        TR.begin();

        try {
            Team team = new Team();
            team.setName("TeamA");
            EM.persist(team);

            Member member = new Member();
            member.setName("member1");
            member.setTeam(team);
            EM.persist(member);

            EM.flush();
            EM.clear();
            Member findMember = EM.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for (Member m : members) {
                System.out.println(m.getName());
            }


            TR.commit();

        } catch (Exception e) {
            e.printStackTrace();
            TR.rollback();
        } finally {
            EM.close();
        }
        EMF.close();
    }
}
