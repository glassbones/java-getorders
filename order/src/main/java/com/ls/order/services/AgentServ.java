package com.ls.order.services;
import com.ls.order.models.Agent;

import java.util.List;

public interface AgentServ{
    Agent save(Agent agent);

    List<Agent> findAllAgents();
    Agent findAgentById(long agentcode);
}