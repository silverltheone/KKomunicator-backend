package com.comunicator.kkomunicatorbackend.controller;

import com.comunicator.kkomunicatorbackend.dto.InvitationDto;
import com.comunicator.kkomunicatorbackend.facade.InvitationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/invitation")
public class InvitationController {

    @Autowired
    private InvitationFacade facade;

    @GetMapping
    public List<InvitationDto> getAll() {
        return facade.getAll();
    }

    @GetMapping("/{id}")
    public InvitationDto get(@PathVariable Long id) throws InvitationNotFoundException {
        return facade.get(id);
    }

    @GetMapping(value = "/getInvitationBySenderOrReceiverId/{id}")
    public List<InvitationDto> getInvitationBySenderOrReceiverId(@PathVariable Long id) throws InvitationNotFoundException {
        return facade.getInvitationBySenderOrReceiverId(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public InvitationDto create(@RequestBody InvitationDto invitationDto) throws UserNotFoundException {
        return facade.create(invitationDto);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public InvitationDto update(@RequestBody InvitationDto invitationDto) throws UserNotFoundException {
        return facade.update(invitationDto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) throws InvitationNotFoundException {
        return facade.delete(id);
    }
}
