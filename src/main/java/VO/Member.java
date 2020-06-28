package VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name = "user") user라는 테이블에 쿼리가 나가도록 변경
public class Member {

    @Id
    private long id;

//    @Column(name = "user_name", unique = true, length = 10, nullable = false)
//    user_name이란 컬럼으로 길이10, not null, unique옵션 붙여서 create/update
//    DB자동생성 옵션이 활성화되어있을떄 적용(create랑 update말고는 저 옵션이 활용될수없기때문)
    private String name;

    public Member(){}
    public Member(long l, String june) {
    }

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
