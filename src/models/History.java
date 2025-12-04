package models;

import containers.Stack;

public class History {
    private Stack<Song> history;

    public History(){
        history = new Stack<>(100);
    }

    public Stack<Song> getHistory() {
        return history;
    }
}
