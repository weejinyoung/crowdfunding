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

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupportService {

    private final SupportRepository supportRepository;
    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    public Long supportProject(Long memberId, Long projectId) {
        Member member = memberRepository.findOne(memberId);
        Project project = projectRepository.findOne(projectId);
        Support support = Support.createSupport(member, project);
        return supportRepository.save(support);
    }

    public List<Support> findSupportBySupporter(String name) {
        return supportRepository.findBySupporter(name);
    }

    public List<Support> findSupportByProject(String projectName) {
        return supportRepository.findByProject(projectName);
    }
}
