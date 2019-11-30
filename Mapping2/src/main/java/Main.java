import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction ET = EM.getTransaction();
        ET.begin();

        Member M = new Member();

        M.setName("준석");
        M.setAge(3);
        EM.persist(M);
        ET.commit();
        EM.close();
        EMF.close();

    }
}
