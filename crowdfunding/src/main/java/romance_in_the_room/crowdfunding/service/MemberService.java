package romance_in_the_room.crowdfunding.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import romance_in_the_room.crowdfunding.domain.member.Member;
import romance_in_the_room.crowdfunding.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member.getMyId());
        return memberRepository.saveMember(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    private void validateDuplicateMember(String myId) {
        Member findMember = memberRepository.findByMyId(myId);
        if (findMember == null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

}
