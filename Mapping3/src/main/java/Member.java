import javax.annotation.Generated;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@SequenceGenerator(name ="member_seq_generator", sequenceName = "member_seq")
public class Member {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long id;
//    @Column(name = "name")/* 객체는 유저네임인데 디비에는 네임으로 등록됨.*/
//    @Column(name = "name", updatable = false) /*처음 정의된이후 업뎃 x*/
    @Column(nullable = false) /*notnull으로 생성*/
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING) /*디비에는 RoleType이라는 데이터타입이 없지만 Enumerated어노테이션을 쓰면 들어가짐*/
    private RoleType roleType; /*그리고 롤타입은 스트링으로 해주는게 관리상 편하니까 숫자로 나오는 ORDINAL 사용x*/

    @Temporal(TemporalType.TIMESTAMP) /*디비는 날짜, 시간, 날짜+시간을 다 따로다루기때문에 날짜+시간을 다루는 TIMESTAMP를 지정*/
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDateTime LDT;
    private LocalDate LD;
    @Lob
    private String description;
    @Transient
    private int temp;
    public Member(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}