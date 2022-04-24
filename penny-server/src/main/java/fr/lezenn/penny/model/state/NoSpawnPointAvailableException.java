package fr.lezenn.penny.model.state;

public class NoSpawnPointAvailableException extends RuntimeException {
    public NoSpawnPointAvailableException(String message) {
        super(message);
    }
}
