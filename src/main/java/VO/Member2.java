package VO;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "member")
public class Member2 {

    @Id
    private long id;
    @Column(updatable = false, insertable = false, nullable = false, columnDefinition = "varchar(100) default 'EMPTY'") //업데이트안됨, 인서트안됨, 낫널, 타입 직접지정
    private String name;
    @Enumerated(EnumType.STRING) //Enum타입을 매핑해주는 어노테이션, ORDINAL사용금지! 에러가날수있음
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP) //날짜+시간
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    
    //최신 하이버네이트버전에선 LocalDate, LocalDateTime을쓰면 굳이 Temporal안써도 가능
    private LocalDate testDate1;
    private LocalDateTime testDate2;
    
    @Lob //varchar를 넘는 큰 단위의 데이터타입
    private String description;
    @Transient //이 변수는 DB와 매핑되지않음
    private String temp;
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

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Member2(){}
}
