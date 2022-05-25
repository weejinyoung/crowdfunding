package romance_in_the_room.crowdfunding.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import romance_in_the_room.crowdfunding.domain.funding.Funding;
import romance_in_the_room.crowdfunding.domain.member.Member;
import romance_in_the_room.crowdfunding.domain.project.Project;
import romance_in_the_room.crowdfunding.repository.FundingRepository;
import romance_in_the_room.crowdfunding.repository.MemberRepository;
import romance_in_the_room.crowdfunding.repository.ProjectRepository;

@Service
@RequiredArgsConstructor
public class FundingService {

    private final FundingRepository fundingRepository;
    private final MemberRepository memberRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    public Long funding(Long memberId, Long projectId) {
        Member member = memberRepository.findOne(memberId);
        Project project = projectRepository.findOne(projectId);
        Funding funding = Funding.createFunding(member, project);
        return fundingRepository.save(funding);
    }
}
