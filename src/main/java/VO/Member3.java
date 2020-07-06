package VO;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "member3")
public class Member3 {
    //기본키에 GeneratedValue로 멤버제너레이터를 엮어줬다. 이것은 시퀀스제너레이터기떄문에, 테이블생성시,
    //MY_SEQUENCE 시퀀스를 같이생성해준다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


