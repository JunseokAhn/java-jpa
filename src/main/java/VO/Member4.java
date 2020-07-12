package VO;

import javax.persistence.*;

@Entity
@Table(name = "member4")
@SequenceGenerator(name= "MEMBER_GENERATOR", sequenceName = "MY_SEQUENCE",
        initialValue = 1, allocationSize = 1)
public class Member4 {
    //기본키에 GeneratedValue로 멤버제너레이터를 엮어줬다.
    // 굳이 SequenceGenerator가 없어도 되지만, 이렇게 설정을 넣어줄시
    //MY_SEQUENCE라는 이름으로 시퀀스를 생성해준다.
    @Id
    @GeneratedValue(generator = "MEMBER_GENERATOR", strategy = GenerationType.SEQUENCE)
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

    public Member4(){}
}

//MEBER_GENERATOR라는 제너레이터에 기본키를 매핑시키면, MY_SEQUENCE테이블이 자동생성되고,
//insert를할때마다 MEMBER_SEQ라는 컬럼네임으로 1씩 증가되면서 할당됨.
//얼로케이션사이즈를 증가시키면 얼로케이션사이즈만큼 DB에미리 올려놓고
// 메모리에 얼로케이션사이즈만큼 저장했다가 한번에 커밋함 1이상 설정하려면 최소값50

