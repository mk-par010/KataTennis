package secondsprint.secondstory;

import static org.junit.Assert.*;

import domain.model.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import secondsprint.firststory.Set;

@RunWith(MockitoJUnitRunner.class)
public class SetWithTieBreakTest {

  @Test
  public void should_player_one_wins_set_with_tie_break(){

    Player playerOne = Player.builder().name("playerOne").score(0).gameWon(6).build();
    Player playerTwo = Player.builder().name("playerTwo").score(0).gameWon(6).build();
    playerOne.setTieBreak(10);
    playerTwo.setTieBreak(8);
    SetWithTieBreak set = SetWithTieBreak.builder().build().builder().playerOne(playerOne).playerTwo(playerTwo).build();
    Player setWinner = set.playSet();
    assertEquals(playerOne.getName(), setWinner.getName());
  }

  @Test
  public void should_player_two_wins_set_with_tie_break(){

    Player playerOne = Player.builder().name("playerOne").score(0).gameWon(2).build();
    Player playerTwo = Player.builder().name("playerTwo").score(0).gameWon(6).build();
    playerOne.setTieBreak(11);
    playerTwo.setTieBreak(13);
    SetWithTieBreak set = SetWithTieBreak.builder().build().builder().playerOne(playerOne).playerTwo(playerTwo).build();
    Player setWinner = set.playSet();
    assertEquals(playerTwo.getName(), setWinner.getName());
  }

}