package chainOfResponsibility.Responsibility.manipuladores;

import org.springframework.stereotype.Component;

import chainOfResponsibility.Responsibility.manipuladores.implementacao.Handler;

@Component
public class HandlerB implements Handler {
    private Handler nextHandler;;
    @Override
    public void setNext(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public String handleRequest(String request) {
        if (request.equalsIgnoreCase("B")) {
            return "HandlerB processou a requisição";
        } else if (nextHandler != null) {
            return nextHandler.handleRequest(request);
        }
        return "Nenhum Handler pode processar a requisição";
    }
    
}
