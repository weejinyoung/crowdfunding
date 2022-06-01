package romance_in_the_room.crowdfunding.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import romance_in_the_room.crowdfunding.service.SupportService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SupportController {

    private final SupportService supportService;

    @PostMapping("/crowdfunding/support")
    public SupportProjectResponse supportProjectRequest(@PathVariable @Valid SupportProjectRequest request) {
        Long supportId = supportService.support(request.getMemberId(), request.getProjectId());
        return new SupportProjectResponse(supportId);
    }

    @Data
    @AllArgsConstructor
    static class SupportProjectResponse {
        private Long id;
    }

    @Data
    @AllArgsConstructor
    static class SupportProjectRequest {
        private Long memberId;
        private Long projectId;
    }
}
