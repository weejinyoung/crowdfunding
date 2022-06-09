package romance_in_the_room.crowdfunding.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import romance_in_the_room.crowdfunding.domain.support.Support;
import romance_in_the_room.crowdfunding.domain.member.Member;
import romance_in_the_room.crowdfunding.domain.project.Project;
import romance_in_the_room.crowdfunding.repository.MemberRepository;
import romance_in_the_room.crowdfunding.repository.ProjectRepository;
import romance_in_the_room.crowdfunding.repository.SupportRepository;

@Service
@RequiredArgsConstructor
public class SupportService {

    private final SupportRepository supportRepository;
    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    public Long support(Long memberId, Long projectId) {
        Member member = memberRepository.findOne(memberId);
        Project project = projectRepository.findOne(projectId);
        Support support = Support.createSupport(member, project);
        return supportRepository.save(support);
    }
}
