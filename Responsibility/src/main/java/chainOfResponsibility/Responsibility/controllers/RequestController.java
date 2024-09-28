package chainOfResponsibility.Responsibility.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chainOfResponsibility.Responsibility.manipuladores.HandlerA;
import chainOfResponsibility.Responsibility.manipuladores.HandlerB;
import chainOfResponsibility.Responsibility.manipuladores.implementacao.Handler;

@RestController
@RequestMapping("/api/request")
public class RequestController {
    private Handler handlerA;

    @Autowired
    public RequestController(HandlerA handlerA, HandlerB handlerB) {
        this.handlerA = handlerA;
        handlerA.setNext(handlerB);
    }

    @GetMapping("/{request}")
    public String processRequest(@PathVariable String request){
        return handlerA.handleRequest(request);
    }
}
