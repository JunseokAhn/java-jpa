import VO.Member;

import javax.persistence.*;
import java.util.List;

public class JPQL {

    public static void main(String[] args) {

        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction TS = EM.getTransaction();

        try {
            TS.begin();
            //5번index부터 8개를 가져오는 쿼리
            //테이블이아닌 엔티티객체를 대상으로 검색(select m)
            //객체지향SQL. 방언을바꿔도 쿼리를 바꿀필요없음
            List<Member> list = EM.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();

            for(Member i : list)
                System.out.println(i.getName());
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
