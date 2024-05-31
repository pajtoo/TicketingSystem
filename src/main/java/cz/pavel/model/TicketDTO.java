package cz.pavel.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class TicketDTO {
    private static int idCounter = 0;

    private int id;
    private String timeStamp;
    private int queueOrder; //order in the queue, starting at 0

    public TicketDTO() {
        this.id = ++idCounter;
        this.timeStamp = LocalDateTime
                .now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
