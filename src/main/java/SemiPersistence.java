import VO.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SemiPersistence {
    public static void main(String[] args) {
        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction TS = EM.getTransaction();

        try {
            TS.begin();
            Member member = EM.find(Member.class, 3l);
            member.setName("Sujin");

            //detach는 객체하나만 준영속상태로 만듬
            //EM.detach(member);
            //clear는 영속성컨텍스트안 모든 객체를 준영속상태로 만듬
            //EM.clear();

            //준영속상태 == 그냥 없는거라고보면된다. 그래서 준영속상태로 만들면 find했을떄 쿼리가 한번 더 나감
            Member member2 = EM.find(Member.class, 3l);

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
