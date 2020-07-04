package VO;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "member")
@SequenceGenerator(name= "MEMBER_GENERATOR", sequenceName = "MY_SEQUENCE",
        initialValue = 1, allocationSize = 1)
public class Member3 {
    //기본키에 GeneratedValue로 멤버제너레이터를 엮어줬다. 이것은 시퀀스제너레이터기떄문에, 테이블생성시,
    //MY_SEQUENCE 시퀀스를 같이생성해준다.
    @Id
    @GeneratedValue(generator = "MEMBER_GENERATOR", strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member3(){}
}

//MEBER_GENERATOR라는 제너레이터에 기본키를 매핑시키면, MY_SEQUENCE테이블이 자동생성되고,
//insert를할때마다 MEMBER_SEQ라는 컬럼네임으로 1씩 증가되면서 할당됨.
//얼로케이션사이즈를 증가시키면 얼로케이션사이즈만큼 찰떄까지 커밋안했다가 한번에 커밋함

