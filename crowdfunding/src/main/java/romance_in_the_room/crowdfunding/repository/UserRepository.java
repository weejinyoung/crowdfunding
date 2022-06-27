package romance_in_the_room.crowdfunding.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import romance_in_the_room.crowdfunding.domain.member.UserInfo;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByLoginId(String loginId);
}
