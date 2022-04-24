package fr.lezenn.penny.link;

import fr.lezenn.penny.model.color.Color;
import fr.lezenn.penny.model.maths.Vector2d;
import fr.lezenn.penny.model.state.GameState;
import fr.lezenn.penny.model.state.NoSpawnPointAvailableException;
import fr.lezenn.penny.model.player.Player;
import fr.lezenn.penny.model.state.PlayerAlreadyInGameException;
import fr.lezenn.penny.transfert.PlayerPosition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class PlayerController {

    @Autowired
    private GameState state;

    Logger logger = LoggerFactory.getLogger(PlayerController.class);

    public PlayerController() {
    }

    public PlayerController(GameState state) {
        this.state = state;
    }

    @MessageMapping("/playerPosition")
    @SendTo("/app/players")
    public Optional<PlayerPosition> getPlayerPosition(String name) {
        var result = this.state.getPlayers().stream()
                .filter(player -> player.getName().equals(name))
                .collect(Collectors.toList());

        if (result.size() == 1) {
            var position = new PlayerPosition();
            position.setPlayerName(result.get(0).getName());
            position.setPosX(result.get(0).getPosition().getX());
            position.setPosY(result.get(0).getPosition().getY());
            return Optional.of(position);
        } else {
            return Optional.empty();
        }
    }

    @MessageMapping("/addPlayer")
    @SendTo("/app/players")
    public boolean addPlayer(String name) {
        var player = new Player(name, new Color(100, 100, 100), new Vector2d(0, 0), new Vector2d(0, 1));
        try {
            this.state.addPlayer(player);
        } catch (NoSpawnPointAvailableException | PlayerAlreadyInGameException e) {
            logger.info("[PLAYER CREATION] Creation of player: " + name + "\n\t" + e.getMessage());
            return false;
        }
        return true;
    }

    @MessageMapping("/removePlayer")
    @SendTo("/app/players")
    public boolean removePlayer(String name) {
        return this.state.removePlayer(name);
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }
}
