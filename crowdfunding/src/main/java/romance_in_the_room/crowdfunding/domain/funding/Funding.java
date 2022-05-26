package romance_in_the_room.crowdfunding.domain.funding;

import lombok.Getter;
import romance_in_the_room.crowdfunding.domain.member.Member;
import romance_in_the_room.crowdfunding.domain.project.Project;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Funding {

    @Id
    @GeneratedValue
    @Column(name = "funding_id")
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    public Member member;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    private LocalDateTime fundingDate;

    //멤버 연관관계 메서드//
    public void setMember(Member member) {
        this.member = member;
        member.getFundings().add(this);
    }

    //프로젝트 연관관계 메서드//
    public void setProject(Project project) {
        this.project = project;
        project.getFundings().add(this);
    }

    public static Funding createFunding(Member member, Project project) {
        Funding funding = new Funding();
        funding.setMember(member);
        funding.setProject(project);
        return funding;
    }
}
