package secondsprint.firststory;

import static org.junit.Assert.*;

import domain.model.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SetTest {


  @Test
  public void should_player_one_wins_set(){

    Player playerOne = Player.builder().name("playerOne").score(0).gameWon(7).build();
    Player playerTwo = Player.builder().name("playerTwo").score(0).gameWon(5).build();
    Set set = Set.builder().playerOne(playerOne).playerTwo(playerTwo).build();
    Player setWinner = set.playSet();
    assertEquals(playerOne.getName(), setWinner.getName());
  }

  @Test
  public void should_player_two_wins_set(){

    Player playerOne = Player.builder().name("playerOne").score(0).gameWon(2).build();
    Player playerTwo = Player.builder().name("playerTwo").score(0).gameWon(6).build();
    Set set = Set.builder().playerOne(playerOne).playerTwo(playerTwo).build();
    Player setWinner = set.playSet();
    assertEquals(playerTwo.getName(), setWinner.getName());
  }

}