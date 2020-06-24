import VO.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Register {
    public static void main(String[] args) {

        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction TS = EM.getTransaction();
        //트라이캣치 ctrl alt t
        try {
            TS.begin();

            Member member = new Member();
            member.setId(2L);
            member.setName("Junseok");
            EM.persist(member);

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
