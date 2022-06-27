package romance_in_the_room.crowdfunding.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import romance_in_the_room.crowdfunding.domain.member.UserInfo;
import romance_in_the_room.crowdfunding.domain.member.UserInfoDto;
import romance_in_the_room.crowdfunding.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserInfo loadUserByUsername(String loginId) throws UsernameNotFoundException {
        return userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new UsernameNotFoundException(loginId));
    }

    public Long save(UserInfoDto infoDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        infoDto.setPassword(encoder.encode(infoDto.getPassword()));

        return userRepository.save(UserInfo.builder()
                .email(infoDto.getEmail())
                .auth(infoDto.getAuth())
                .password(infoDto.getPassword()).build()).getCode();
    }
}
