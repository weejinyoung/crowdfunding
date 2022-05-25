package romance_in_the_room.crowdfunding.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import romance_in_the_room.crowdfunding.service.FundingService;

@RestController
@RequiredArgsConstructor
public class FundingController {

    private final FundingService fundingService;

    @PostMapping("/crowdfunding/funding")
    public CreateFundingResponse createFundingRequest(Long id) {
        return new CreateFundingResponse(id);
    }

    @Data
    @AllArgsConstructor
    static class CreateFundingResponse {
        private Long id;
    }
}
