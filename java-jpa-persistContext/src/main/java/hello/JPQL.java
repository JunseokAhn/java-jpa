package hello;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JPQL {
    public static void main(String[] args) {
         EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
         EntityManager EM = EMF.createEntityManager();
         EntityTransaction TR = EM.getTransaction();
         TR.begin();
         try{
             List<Member> result = EM.createQuery("select m from Member as m",Member.class).getResultList();
             for (Member member : result) {//iter
                 System.out.println("member = "+member.getName());
             }
             TR.commit();
         }catch (Exception e){
             TR.rollback();
         }finally {
             EM.close();
         }
         EMF.close();
     }
}
