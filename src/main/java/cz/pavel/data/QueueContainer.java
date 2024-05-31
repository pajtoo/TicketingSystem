package cz.pavel.data;

import cz.pavel.model.TicketDTO;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
@Getter
public class QueueContainer {
    private final Queue<TicketDTO> ticketQueue;

    public QueueContainer() {
        this.ticketQueue = new LinkedList<>();
    }
}
