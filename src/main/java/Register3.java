import VO.Member2;
import VO.Member3;
import VO.RoleType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Register3 {
    public static void main(String[] args) {

        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction TS = EM.getTransaction();
        //트라이캣치 ctrl alt t
        try {
            TS.begin();

            Member3 member = new Member3();
            //soutv
            System.out.println("====================");
            //identity로 쿼리를 날리게되면, 하이버네이트입장에선 값을 insert로 날려봐야
            //pk를 알수있기때문에 영속성컨텍스트에 집어넣는순간 바로 insert를날린다.
            EM.persist(member);
            System.out.println("member.id = " + member.getId());
            System.out.println("====================");

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
