package com.qienProgramma.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qienProgramma.controller.EmployeeRepository;
import com.qienProgramma.controller.EmployeeService;
import com.qienProgramma.controller.MessageService;
import com.qienProgramma.model.Employee;
import com.qienProgramma.model.Messages;

@RestController
@RequestMapping("/api/messages")
public class MessageEndpoint {

	@Autowired
    MessageService msg;
	
	@Autowired
	EmployeeRepository er;
	
	@Autowired
	EmployeeService es;

    @PostMapping("/new")
    public Messages addMessage(@RequestBody Messages messages) {
        return msg.addMessages(messages);
    }

    @GetMapping("/all")
    public Iterable<Messages> getMessages(){
        return msg.getAllMessages();
    }

    @GetMapping("/id/{id}")
    public Messages getMessageByID(@PathVariable(value = "id") long id){
        return msg.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMessageById(@PathVariable(value = "id") long id) {
        msg.deleteMessagesById(id);
    }

    @PutMapping("/update/{id}")
    public Messages updateMessage(@PathVariable(value = "id") long id, @RequestBody Messages messages) {
        return msg.updateMessages(id, messages);
    }

    @PostMapping("/dopost")
    public String doPost(@RequestBody Messages md) {
        System.out.println(md.getMessage());
        return "Post is gelukt";
    }
    
    @PostMapping("/new/all")
    public void addMessageToAll(@RequestBody Messages message) {
        for (Employee em : er.findAll()) {
            es.addMessageToEmployee(em, msg.addMessages(message));
        }
    }
    

}


