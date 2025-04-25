package pl.niziolekp.app.graphservice.domain.model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Connection {
    private String sourceUserId;
    private String targetUserId;
    private String relationshipType;
}
