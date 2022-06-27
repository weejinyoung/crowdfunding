package romance_in_the_room.crowdfunding.domain.member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class UserInfo implements UserDetails {

    @Id
    @Column(name = "code")
    @GeneratedValue
    private Long code;

    @Column(name = "loginId", unique = true)
    private String loginId;

    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "email", unique = true)
    @Email
    private String email;

    @Column(name = "auth")
    private String auth;

    @Builder
    public UserInfo(String loginId, String password, String email, String auth) {
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.auth = auth;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role : auth.split(",")) {
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getLoginId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
