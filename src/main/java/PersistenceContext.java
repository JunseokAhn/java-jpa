import VO.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistenceContext {

    public static void main(String[] args) {

        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction TS = EM.getTransaction();

        try {
            TS.begin();
            //비영속상태
            Member member = new Member();
            member.setId(3l);
            member.setName("june");

            System.out.println("======before=====");
            //영속상태
            EM.persist(member);

            //다시 비영속상태로 만듬
            //EM.detach(member);

            //DB삭제요청
            //EM.remove(member)
            System.out.println("======after=====");

            //조회 한번하면 자동으로 1차캐시에 등록돼서 두번째 select문이 안나간다.
            Member member1 = EM.find(Member.class, 2l);
            Member member2 = EM.find(Member.class, 2l);

            //같은 1차캐쉬에서 가져왔으니까 true
            System.out.println(member1==member2);
            //persist에 저장된 객체들이 커밋할때 쿼리가작성되어 나감
            
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
