import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
            member.setUserName("member1");
//            member.setTeamId(team.getId());
            member.setTeam(team);
            EM.persist(member);

            Member findMember = EM.find(Member.class, member.getId());
//            Team findTeam = EM.find(Team.class, findMember.getTeamId());
            Team findTeam = findMember.getTeam();
            System.out.println("TeamName = "+findTeam.getName());

            Team newTeam = EM.find(Team.class, 100l);
            findMember.setTeam(newTeam);
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
