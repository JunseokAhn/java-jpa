import VO.Member;

import javax.persistence.*;

public class Flush {
    public static void main(String[] args) {

        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction TS = EM.getTransaction();

        try {
            TS.begin();
            Member member = new Member(3l, "June");
            EM.persist(member);
            EM.flush();
            
            System.out.println("커밋하기전에 플러쉬를해서 insert문이 나간다");
            //플러쉬 = DB에 자료를 등록할때 나감 즉, 커밋할떄도 플러쉬가 나감.
            //플러쉬를 커밋할때만 나가게 하는 세팅
            EM.setFlushMode(FlushModeType.COMMIT);
            //플러쉬를 JPQL, COMMIT, EM.flush()하는 경우 전부 플러쉬시킨다
            EM.setFlushMode(FlushModeType.AUTO);
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
