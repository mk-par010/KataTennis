package firstsprint.secondstory;

import static org.junit.Assert.assertEquals;

import domain.model.Player;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GameWithDeuceCaseTest  {


  @Test
  public void void_should_player_one_wins_the_game() {

    String namePlayerOne = "player One";
    String namePlayerTwo = "player Two";

    GameWithDeuceCase game = GameWithDeuceCase
        .builder()
        .playerOne(Player.builder().name(namePlayerOne).score(4).build())
        .playerTwo(Player.builder().name(namePlayerTwo).score(1).build())
        .build();

    Optional<Player> optionalPlayer = game.playGame();
    assertEquals(optionalPlayer.get().getName(), namePlayerOne);
  }

  @Test
  public void void_should_player_two_wins_the_game() {

    String namePlayerOne = "player One";
    String namePlayerTwo = "player Two";

    GameWithDeuceCase game = GameWithDeuceCase
        .builder()
        .playerOne(Player.builder().name(namePlayerOne).score(1).build())
        .playerTwo(Player.builder().name(namePlayerTwo).score(4).build())
        .build();

    Optional<Player> optionalPlayer = game.playGame();
    assertEquals(optionalPlayer.get().getName(), namePlayerTwo);
  }

  @Test
  public void void_should_player_one_wins_the_game_after_deuce_case() {

    String namePlayerOne = "player One";
    String namePlayerTwo = "player Two";

    GameWithDeuceCase game = GameWithDeuceCase
        .builder()
        .playerOne(Player.builder().name(namePlayerOne).score(8).build())
        .playerTwo(Player.builder().name(namePlayerTwo).score(6).build())
        .build();

    Optional<Player> optionalPlayer = game.playGame();
    assertEquals(optionalPlayer.get().getName(), namePlayerOne);
  }

  @Test
  public void void_should_player_two_wins_the_game_after_deuce_case() {

    String namePlayerOne = "player One";
    String namePlayerTwo = "player Two";

    GameWithDeuceCase game = GameWithDeuceCase
        .builder()
        .playerOne(Player.builder().name(namePlayerOne).score(13).build())
        .playerTwo(Player.builder().name(namePlayerTwo).score(15).build())
        .build();

    Optional<Player> optionalPlayer = game.playGame();
    assertEquals(optionalPlayer.get().getName(), namePlayerTwo);
  }

}
