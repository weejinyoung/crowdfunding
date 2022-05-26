package romance_in_the_room.crowdfunding.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import romance_in_the_room.crowdfunding.domain.member.Member;
import romance_in_the_room.crowdfunding.service.MemberService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/crowdfunding/member")
    public CreateMemberResponse saveMember(@RequestBody @Valid CreateMemberRequest request) {
        Member member = Member.createBasicInfo(request.getMyId(), request.getPassword(), request.getName(), request.getEmail());
        Long id = memberService.saveMember(member);
        return new CreateMemberResponse(id);
    }

    @Data
    @AllArgsConstructor
    static class CreateMemberResponse {
        private Long id;
    }

    @Data
    @AllArgsConstructor
    static class CreateMemberRequest {
        String myId;
        String password;
        String name;
        String email;
    }
}
