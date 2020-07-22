package Oneway_Association;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction TS = EM.getTransaction();

        TS.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            EM.persist(team);

            Oneway_Member member = new Oneway_Member();
            member.setUserName("Junseok");
//          team을 영속상태에 두었기때문에 GenerateValue에 의해 id가 생성될것이고, 그 id값을 매핑해준다
//          member.setTeamId(team.getId());
//          매니투원 조인컬럼 팀아이디를 매핑시켜버렸기때문에 그냥 setTeam해주면 team에서 id값을 가져와서 매핑해버림
            member.setTeam(team);
            EM.persist(member);

            Oneway_Member FindMember = EM.find(Oneway_Member.class, member.getId());
            Team FindTeam = FindMember.getTeam();
            System.out.println("=============");
//          팀 insert는 커밋시점에 나가지만, 커밋안해도 매핑된시점에서 찾아오는건 가능
            System.out.println("팀id : "+FindTeam.getId());
            System.out.println("=============");

            TS.commit();
        } catch (Exception e) {
            e.printStackTrace();
            TS.rollback();
        } finally {
            EM.close();
        }
        EMF.close();

    }
}
