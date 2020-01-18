import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
public class Member {

    @Id @GeneratedValue @Column(name = "MEMBER_ID")
    private long id;

    @Column(name = "USERNAME")
    private String userName;

   /* @Column(name = "TEAM_ID")
    private long teamId;*/
    @ManyToOne @JoinColumn(name = "TEAM_ID")
    private Team team;
}
