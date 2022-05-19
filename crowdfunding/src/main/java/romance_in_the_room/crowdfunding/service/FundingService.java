package romance_in_the_room.crowdfunding.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import romance_in_the_room.crowdfunding.repository.FundingRepository;

@Service
@RequiredArgsConstructor
public class FundingService {

    private final FundingRepository fundingRepository;

    

}
