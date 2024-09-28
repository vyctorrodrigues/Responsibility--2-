package chainOfResponsibility.Responsibility.manipuladores.implementacao;


public interface Handler {
    void setNext(Handler nextHandler);
    String handleRequest(String request);
}
