package hello;

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
        try{
            Member M = new Member();
            M.setId(100L);
            M.setName("member1");
            EM.persist(M);
            EM.flush(); /* EM.clear();= 영속성콘텍스트 전부 클리어 */
            EM.detach(M);
            Member finder = EM.find(Member.class, 100L);
            finder.setName("member2");


            TR.commit();
        }catch(Exception e){
          TR.rollback();
        }finally {
          EM.close();
        }

        EMF.close();
    }
}
