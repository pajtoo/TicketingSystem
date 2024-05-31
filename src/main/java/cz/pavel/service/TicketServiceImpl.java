package cz.pavel.service;

import cz.pavel.data.QueueContainer;
import cz.pavel.model.TicketDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Queue;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private QueueContainer queueContainer;

    private Queue<TicketDTO> queue;

    @PostConstruct
    public void init() {
        queue = queueContainer.getTicketQueue();
    }

    @Override
    public TicketDTO generateTicket() {
        TicketDTO ticket = new TicketDTO();
        ticket.setQueueOrder(queue.size());
        queue.offer(ticket);
        return ticket;
    }

    @Override
    public TicketDTO getFirstInLine() {
        return queue.peek();
    }

    @Override
    public void deleteFirstInLine() {
        if (queue.poll() != null) {
            queue.forEach(
                    ticket -> ticket.setQueueOrder(ticket.getQueueOrder() - 1)
            );
        }
    }
}
