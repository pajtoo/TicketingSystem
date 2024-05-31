package cz.pavel.service;

import cz.pavel.model.TicketDTO;

public interface TicketService {

    TicketDTO generateTicket();
    TicketDTO getFirstInLine();
    void deleteFirstInLine();

}
