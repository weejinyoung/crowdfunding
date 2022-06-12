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
    public Long joinMember(Member member) {
        validateDuplicateMember(member.getLoginId());
        return memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findMemberByLoginRequest(String loginId, String password) {
        Member findMember = memberRepository.findByLoginId(loginId);
        if(findMember == null) {
            throw new IllegalStateException("아이디를 확인해주세요");
        }
        if (!findMember.getPassword().equals(password)) {
            throw new IllegalStateException("비밀번호를 확인해주세요");
        }
        return findMember;
    }

    private void validateDuplicateMember(String loginId) {
        Member findMember = memberRepository.findByLoginId(loginId);
        if (findMember == null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
