package com.ls.order.controllers;

import com.ls.order.models.Agent;
import com.ls.order.services.AgentServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/agents")
public class AgentController {
    @Autowired
    private AgentServ agentServ;

    //http://localhost:1337/agents/agent
    @GetMapping(value = "/agent", produces = {"application/json"})
    public ResponseEntity<?> listAllAgents(){
        List<Agent> myAgents = agentServ.findAllAgents();
        return new ResponseEntity<>(myAgents, HttpStatus.OK);
    }

    //http://localhost:1337/agents/agents/3
    @GetMapping(value = "/agent/{agentcode}", produces = {"application/json"})
    public ResponseEntity<?> findAgentById(@PathVariable long agentcode){
        Agent a = agentServ.findAgentById(agentcode);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }
}

