package com.ls.order.services;

import com.ls.order.models.Agent;
import com.ls.order.repos.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

//@Transactional
@Service(value = "agentServ")
public class AgentServImpli implements AgentServ {

    @Autowired
    private AgentRepo agentRepos;

    @Transactional
    @Override
    public Agent save(Agent agent) { return agentRepos.save(agent); }

    @Override
    public List<Agent> findAllAgents() {
        List<Agent> list = new ArrayList<>();

        agentRepos.findAll().iterator().forEachRemaining(list::add);

        return list;
    }

    @Override
    public Agent findAgentById(long agentcode) {

        return agentRepos.findById(agentcode)
                .orElseThrow(() -> new EntityNotFoundException("Agent " + agentcode + " isn't here my dude."));

    }

}