package romance_in_the_room.crowdfunding.domain.project;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class ProjectDateInfo {

    @Id

    private LocalDateTime postDate;
    private LocalDateTime lastChangeDate;
    private LocalDateTime deadLine;
}
