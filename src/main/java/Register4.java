import VO.Member3;
import VO.Member4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Register4 {
    public static void main(String[] args) {

        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction TS = EM.getTransaction();
        //트라이캣치 ctrl alt t
        try {
            TS.begin();

            Member4 member = new Member4();
            //soutv
            System.out.println("====================");
            /*identity는 알아서 db에서 시퀀스를 만들어주기떄문에 insert해봐야 값을 알지만
             시퀸스전략은 내가 GeneratedValue로 시퀀스를 생성해주기때문에 시퀸스에서 call next value한 다음에
             인덱스를 기억해놨다가 나중에 한번에 (allocationSize)커밋한다.*/
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
