package romance_in_the_room.crowdfunding.domain.member;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoDto {
    private String loginId;
    private String password;
    private String email;
    private String auth;
}
