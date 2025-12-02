package handlers;

@FunctionalInterface
public interface Command {
    void execute(String[] args);
}