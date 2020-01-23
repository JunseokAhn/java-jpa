import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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

//            EM.flush();플러시클리어 > add멤버 안해도 서버에서 불러오지만
//            EM.clear(); 이게없으면 캐시에서 읽어오기때문에 어드멤버해야함

//            team.getMembers().add(member); member에 편의메소드생성; 자동으로 team에 memeber를 add;
            Member findMember = EM.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for (Member m : members) {
                System.out.println(m.getName());
            }

            Team findTeam = EM.find(Team.class, team.getId());
            List<Member> members2 = findTeam.getMembers();
            for (Member m : members2) {
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
