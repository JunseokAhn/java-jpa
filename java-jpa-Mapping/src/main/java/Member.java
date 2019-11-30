import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    @Id
    private Long id;
    @Column(name = "name")/* 객체는 유저네임인데 디비에는 네임으로 등록됨.*/
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING) /*디비에는 RoleType이라는 데이터타입이 없지만 Enumerated어노테이션을 쓰면 들어가짐*/
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP) /*디비는 날짜, 시간, 날짜+시간을 다 따로다루기때문에 날짜+시간을 다루는 TIMESTAMP를 지정*/
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;
    @Transient
    private int temp;
    public Member(){}
}