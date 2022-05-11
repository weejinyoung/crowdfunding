package romance_in_the_room.crowdfunding.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String password;

    @Column(name = "name")
    private String username;

    @Email
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
}
