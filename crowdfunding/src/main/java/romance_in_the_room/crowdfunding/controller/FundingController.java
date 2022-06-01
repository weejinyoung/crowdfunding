package romance_in_the_room.crowdfunding.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import romance_in_the_room.crowdfunding.domain.funding.Funding;
import romance_in_the_room.crowdfunding.service.FundingService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class FundingController {

    private final FundingService fundingService;

    @PostMapping("/crowdfunding/funding")
    public PostFundingResponse createFundingRequest(@PathVariable @Valid PostFundingRequest request) {
        Long fundingId = fundingService.funding(request.getMemberId(), request.getProjectId());
        return new PostFundingResponse(fundingId);
    }

    @Data
    @AllArgsConstructor
    static class PostFundingResponse {
        private Long id;
    }

    @Data
    @AllArgsConstructor
    static class PostFundingRequest {
        private Long memberId;
        private Long projectId;
    }
}
