package fr.lezenn.penny.model.state;

import fr.lezenn.penny.model.maths.Vector2d;
import fr.lezenn.penny.model.player.Player;
import fr.lezenn.penny.model.world.WorldMap;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class GameState {

    private final List<Player> players;
    private final List<String> playerNames;
    private final WorldMap map;

    private final Random random;

    public GameState() {
        this.random = new Random();
        this.players = new ArrayList<>();
        this.playerNames = new ArrayList<>();
        this.map = new WorldMap(1000);
    }

    /**
     * Adds a player in the current game
     * @param player Player who joined the game
     * @throws PlayerAlreadyInGameException Thrown when a player with the given name is already ingame
     * @throws NoSpawnPointAvailableException Thrown when the game isn't able to generate a spawn point for the player
     */
    public void addPlayer(Player player) throws PlayerAlreadyInGameException, NoSpawnPointAvailableException {
        if (!playerNames.contains(player.getName())) {
            Optional<Vector2d> playerPosition = this.getSpawnPosition();

            if (playerPosition.isPresent()) {
                player.setPosition(playerPosition.get());
            } else {
                throw new NoSpawnPointAvailableException("No more attempts to get a spawn point");
            }

            players.add(player);
        } else {
            throw new PlayerAlreadyInGameException("This player already exists in the current game.");
        }
    }

    /**
     * Generate a new spawn point for a player
     * @return A vector2d if the spawn point is found, else Empty
     */
    public Optional<Vector2d> getSpawnPosition() {
        // 150 attempts
        for (int i = 0; i < 150; i++) {
            double theta = random.nextDouble() * 2 * Math.PI;
            double r = this.map.getSize() * Math.sqrt(random.nextDouble());
            var spawnPoint = new Vector2d(r * Math.cos(theta), r * Math.sin(theta));

            long insideShapes = players.stream().filter(player -> player.getShape().containsPoint(spawnPoint)).count();
            if (insideShapes == 0) {
                return Optional.of(spawnPoint);
            }
        }
        return Optional.empty();
    }

    /**
     * Removes a player from the current game.
     * @param name Name of the player to remove.
     */
    public boolean removePlayer(String name) {
        if (playerNames.contains(name)) {
            players.removeIf(player -> player.getName().equals(name));
            playerNames.removeIf(playerName -> playerName.equals(name));
            return true;
        }
        return false;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public WorldMap getMap() {
        return map;
    }

    /**
     * Update game loop for the server state
     */
    @Scheduled(fixedRate = 17)
    public void update() {

    }
}
