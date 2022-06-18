package romance_in_the_room.crowdfunding.domain.member;

import lombok.Builder;
import lombok.Getter;
import romance_in_the_room.crowdfunding.domain.support.Support;
import romance_in_the_room.crowdfunding.domain.project.Project;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
//멤버 입장에서 One, 프로젝트 입장에선 Many이기 때문에 OneToMany
//한 프로젝트의 소유주는 멤버 한명, 하지만 멤버는 여러가지의 프로젝트를 소유할 수 있다
//객체는 단방향 연결 두개, 디비는 양방향 따라서 두개의 패러다임 불일치
//일대다에서 '다' 외래키가 있는곳이 연관관계의 주인, 주인이 아니면 mapped by로 맵핑
//mapped by는 조회만 가능, 주인이 변경까지 가능
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String loginId;

    @NotEmpty
    @Column(unique = true)
    private String password;

    @Column(unique = true)
    private String name;

    @Email
    private String email;

    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "supporter")
    private List<Support> supports = new ArrayList<>();

    @OneToMany(mappedBy = "projectMaker")
    private List<Project> projects = new ArrayList<>();


    protected Member (String loginId, String password, String name, String email) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.createdDate = LocalDateTime.now();
    }

    //protected 기본 생성자
    protected Member() {

    }

    public static Member createMember(String myId, String password, String name, String email) {
       return new Member(myId, password, name, email);
    }

   /* public static Member findMember(String myId, String password) {

    }*/
}
