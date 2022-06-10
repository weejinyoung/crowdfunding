package romance_in_the_room.crowdfunding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import romance_in_the_room.crowdfunding.domain.member.Member;
import romance_in_the_room.crowdfunding.service.MemberService;


@SpringBootTest
public class MemberTest {

    @Autowired
    private MemberService memberService;

    @Test
    @Transactional
    void createMember() {
        Member member1 = Member.createMember("a8118199", "004637", "wee", "a8118199@gmail.com");
        Long id = memberService.joinMember(member1);
        Member member2 = memberService.findMember(id);
        Assertions.assertThat(member1).isEqualTo(member2);
    }
}
