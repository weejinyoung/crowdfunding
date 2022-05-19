package romance_in_the_room.crowdfunding.domain.project;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.time.LocalDateTime;

@Embeddable
@Getter @Setter
public class ProjectDateInfo {

    private LocalDateTime postDate;
    private LocalDateTime lastChangeDate;
    private LocalDateTime deadLine;
}
