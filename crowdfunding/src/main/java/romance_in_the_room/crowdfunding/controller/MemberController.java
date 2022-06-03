package romance_in_the_room.crowdfunding.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import romance_in_the_room.crowdfunding.domain.member.Member;
import romance_in_the_room.crowdfunding.service.MemberService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping ("/crowdfunding/member/join")
    public joinNewMemberResponse joinNewMember(@RequestBody @Valid joinNewMemberRequest request) {
        Member member = Member.createMember(request.getMyId(), request.getPassword(), request.getName(), request.getEmail());
        Long id = memberService.saveMember(member);
        return new joinNewMemberResponse(id);
    }

    @GetMapping("/crowdfunding/member/find-my-info")
    public findMemberResponse findMy(@RequestBody @Valid findMemberRequest request) {
        Member member = memberService.findMember(request.getMyId(), request.getPassword());
        return new findMemberResponse();
    }

    @Data
    @AllArgsConstructor
    static class joinNewMemberResponse {
        private Long id;
    }

    @Data
    @AllArgsConstructor
    static class joinNewMemberRequest {
        String myId;
        String password;
        String name;
        String email;
    }

    @Data
    @AllArgsConstructor
    static class findMemberResponse {
    }

    @Data
    @AllArgsConstructor
    static class findMemberRequest {
        public Long myId;
        public String password;
    }
}
