package romance_in_the_room.crowdfunding.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import romance_in_the_room.crowdfunding.service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/crowdfunding/member")
    public MemberResponse findOne() {
        return null;
    }

    @Data
    @AllArgsConstructor
    static class MemberResponse {
        private String name;
    }
}
