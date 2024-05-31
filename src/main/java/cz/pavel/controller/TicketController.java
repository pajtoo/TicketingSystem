package cz.pavel.controller;

import cz.pavel.model.TicketDTO;
import cz.pavel.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/ticket")
@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public TicketDTO generateTicket() {
        return ticketService.generateTicket();
    }

    @GetMapping
    public TicketDTO getFirstInLine() {
        return ticketService.getFirstInLine();
    }

    @DeleteMapping
    public void deleteFirstInLine() {
        ticketService.deleteFirstInLine();
    }


}
