package fr.lezenn.penny.transfert;

import java.util.Objects;

public class PlayerPosition {

    private String playerName;

    private double posX;
    private double posY;

    public PlayerPosition() {
    }

    public PlayerPosition(String playerName, double posX, double posY) {
        this.playerName = playerName;
        this.posX = posX;
        this.posY = posY;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerPosition that = (PlayerPosition) o;
        return Double.compare(that.posX, posX) == 0 && Double.compare(that.posY, posY) == 0 && Objects.equals(playerName, that.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, posX, posY);
    }
}
