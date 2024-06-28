package cz.pavel.service;

import cz.pavel.data.QueueContainer;
import cz.pavel.model.TicketDTO;
import org.springframework.stereotype.Service;

import java.util.Queue;

@Service
public class TicketServiceImpl implements TicketService {

    private Queue<TicketDTO> queue;

    public TicketServiceImpl(QueueContainer queueContainer) {
        this.queue = queueContainer.getTicketQueue();
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
