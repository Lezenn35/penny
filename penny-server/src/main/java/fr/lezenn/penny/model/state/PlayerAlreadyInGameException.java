package fr.lezenn.penny.model.state;

public class PlayerAlreadyInGameException extends RuntimeException {
    public PlayerAlreadyInGameException(String message) {
        super(message);
    }
}
