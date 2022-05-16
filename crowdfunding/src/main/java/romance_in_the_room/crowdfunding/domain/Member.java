package romance_in_the_room.crowdfunding.domain;

import lombok.Getter;
import lombok.Setter;
import romance_in_the_room.crowdfunding.domain.project.Project;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
//멤버 입장에서 One, 프로젝트 입장에선 Many이기 때문에 OneToMany
//한 프로젝트의 소유주는 멤버 한명, 하지만 멤버는 여러가지의 프로젝트를 소유할 수 있다
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

    @OneToMany
    private List<Project> projects = new ArrayList<>();
}
