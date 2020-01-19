import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
public class Team {
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private int id;
    @Column(name = "TEAM_NAME")
    private String name;
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<Member>();

}
