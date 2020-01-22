import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
public class Member {
    @Id @Column(name = "MEMBER_ID")
    private int id;
    @Column(name = "MEMBER_NAME")
    private String name;
    @ManyToOne @JoinColumn(name = "TEAM_ID")
    Team team;


    public void setTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }

}


