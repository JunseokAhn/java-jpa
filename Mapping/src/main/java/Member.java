import javax.persistence.*;
import java.util.Date;

}@Entity
@SequenceGenerator(
        name = "member_id_generator",
        sequenceName = "ID",
        initialValue = 1, allocationSize = 50)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_id_generator")
    private Long id;
//    만약 generatedValue stragegy = identity라면, 트랜잭션커밋하면서 identity가 등록되기때문에
//    getID등으로 참조하게되면 커밋하기전 persist단계에서 먼저 insert를 날리고 참조한뒤 커밋하게된다.

    //    @Column(name = "name")/* 객체는 유저네임인데 디비에는 네임으로 등록됨.*/
//    @Column(name = "name", updatable = false) /*처음 정의된이후 업뎃 x*/
    @Column(name = "userName", nullable = false)
    private String name;
    private int age;
//    @Enumerated(EnumType.STRING) /*디비에는 RoleType이라는 데이터타입이 없지만 Enumerated어노테이션을 쓰면 들어가짐*/
//    private RoleType roleType; /*그리고 롤타입은 스트링으로 해주는게 관리상 편하니까 숫자로 나오는 ORDINAL 사용x*/
//
//    @Temporal(TemporalType.TIMESTAMP) /*디비는 날짜, 시간, 날짜+시간을 다 따로다루기때문에 날짜+시간을 다루는 TIMESTAMP를 지정*/
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    private LocalDateTime LDT;
//    private LocalDate LD;
//    @Lob
//    private String description;
//    @Transient
//    private int temp;


    public Member() {
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
