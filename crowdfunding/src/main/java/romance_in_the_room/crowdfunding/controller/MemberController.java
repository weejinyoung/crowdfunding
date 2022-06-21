package romance_in_the_room.crowdfunding.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import romance_in_the_room.crowdfunding.domain.member.Member;
import romance_in_the_room.crowdfunding.service.MemberService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crowdfunding/")
public class MemberController {

    private final MemberService memberService;

    @PostMapping ("member/join")
    public joinNewMemberResponse joinNewMember(@RequestBody joinNewMemberRequest request) {
        Member member = Member.createMember(request.getLoginId(), request.getPassword(), request.getName(), request.getEmail());
        Long id = memberService.joinMember(member);
        return new joinNewMemberResponse(id);
    }

    @GetMapping("member/find-my-info/id")
    public findMemberResponse findMyInfo(@RequestBody @Valid findMemberRequest request) {
        Member findMember = memberService.findMember(request.getMyId());
        return new findMemberResponse();
    }

    @GetMapping("member/login")
    public loginMemberResponse loginMember(@RequestBody @Valid loginMemberRequest request) {
        Member loginMember = memberService.findMemberByLoginRequest(request.getLoginId(), request.getPassword());
        return new loginMemberResponse(loginMember.getName());
    }

    @GetMapping("member/logout")
    public logoutMemberResponse logoutMember(@RequestBody @Valid logoutMemberRequest request) {
        return null;
    }


    @Data
    @AllArgsConstructor
    static class joinNewMemberResponse {
        private Long id;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class joinNewMemberRequest {
        String loginId;
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

    @Data
    @AllArgsConstructor
    static class loginMemberResponse {
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class loginMemberRequest {
        private String loginId;
        private String password;
    }

    @Data
    @AllArgsConstructor
    static class logoutMemberResponse {
    }

    @Data
    @AllArgsConstructor
    static class logoutMemberRequest {
    }
}
