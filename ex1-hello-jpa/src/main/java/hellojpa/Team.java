package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Team {
    @Id @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "team") //Member의 team과 연결, Team의 반대편에 걸려 있는 것을 표기
    private List<Member> members = new ArrayList<>();
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

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
