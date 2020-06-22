import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Refactor {
    public static void main(String[] args) {

        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction TS = EM.getTransaction();

        try {
            TS.begin();
            Member member = EM.find(Member.class, 1L);
            member.setName("Junsoku");

            //트랜잭션 커밋을 하기전에 JPA가 캐쉬가 변경이 되었는지 체크를하고, 변경이있으면 그걸 업데이트하고 커밋함
            //마치 자바 콜렉션처럼 동작
            //그래서 EM.persister(memeber)안해줘도 된다.
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
