package firstsprint.firststory;

import static org.junit.Assert.assertEquals;

import domain.model.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class GameTest{

    @Test
    public void void_should_player_one_wins_the_game() {

        String namePlayerOne = "player One";
        String namePlayerTwo = "player Two";

        Game game = Game
            .builder()
            .playerOne(Player.builder().name(namePlayerOne).score(4).build())
            .playerTwo(Player.builder().name(namePlayerTwo).score(3).build())
            .build();

        Optional<Player> optionalPlayer = game.playGame();
        assertEquals(optionalPlayer.get().getName(), namePlayerOne);
    }

  @Test
  public void void_should_player_two_wins_the_game() {

    String namePlayerOne = "player One";
    String namePlayerTwo = "player Two";

    Game game = Game
        .builder()
        .playerOne(Player.builder().name(namePlayerOne).score(0).build())
        .playerTwo(Player.builder().name(namePlayerTwo).score(4).build())
        .build();

    Optional<Player> optionalPlayer = game.playGame();
    assertEquals(optionalPlayer.get().getName(), namePlayerTwo);
  }


}
