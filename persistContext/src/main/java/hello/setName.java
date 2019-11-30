package hello;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class setName {
    public static void main(String[] args) {
        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction TR = EM.getTransaction();
        TR.begin();
        try{
            Member findMember = EM.find(Member.class, 2L);
            findMember.setName("아이디가2L인 사람");
            TR.commit();
        }catch (Exception e){
            TR.rollback();
        }finally {
            EM.close();
        }
       EMF.close();
    }
}
