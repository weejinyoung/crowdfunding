package romance_in_the_room.crowdfunding.domain.member;

import lombok.Getter;
import lombok.Setter;
import romance_in_the_room.crowdfunding.domain.funding.Funding;
import romance_in_the_room.crowdfunding.domain.project.Project;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
//멤버 입장에서 One, 프로젝트 입장에선 Many이기 때문에 OneToMany
//한 프로젝트의 소유주는 멤버 한명, 하지만 멤버는 여러가지의 프로젝트를 소유할 수 있다
//객체는 단방향 연결 두개, 디비는 양방향 따라서 두개의 패러다임 불일치
//외래키가 있는곳이 연관관계의 주인, 주인이 아니면 mapped by로 맵핑
//mapped by는 조회만 가능, 주인이 변경까지 가능
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String password;

    @Column(name = "name")
    private String name;

    @Email
    private String email;

    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "member")
    private List<Funding> fundings = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Project> projects = new ArrayList<>();
}
