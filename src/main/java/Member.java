import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "user") user라는 테이블에 쿼리가 나가도록 변경
public class Member {

    @Id
    private long id;

//    @Column(name = "user_name") user_name이라는 컬럼으로 쿼리가 나가도록 변경
    private String name;

    //자동완성 alt insert
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
