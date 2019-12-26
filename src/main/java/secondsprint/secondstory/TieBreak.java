package secondsprint.secondstory;

import domain.model.Player;
import java.util.Optional;
import java.util.Random;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class TieBreak {

  private Player playerOne;
  private Player playerTwo;


  public void tieBreakPoint(Player player) {
    player.setTieBreak(player.getTieBreak() + 1);
  }

  public Optional<Player> getTieBreakWinner() {

    int tieBreakFirstPlayer = playerOne.getTieBreak();
    int tieBreakSecondPlayer = playerTwo.getTieBreak();

    if (tieBreakFirstPlayer >= 7 && (tieBreakFirstPlayer - tieBreakSecondPlayer == 2)) {
      return Optional.of(playerOne);
    }

    if (tieBreakSecondPlayer >= 7 && (tieBreakSecondPlayer - tieBreakFirstPlayer == 2)) {
      return Optional.of(playerTwo);
    }
    return Optional.empty();
  }

  public Optional<Player> playTieBreak() {

    Random random = new Random();
    Optional<Player> optionalPlayer;

    while (!(optionalPlayer = getTieBreakWinner()).isPresent()) {
      if (random.nextInt(100) % 2 == 0) {
        this.tieBreakPoint(playerOne);
      } else {
        this.tieBreakPoint(playerTwo);
      }
    }

    optionalPlayer.ifPresent(player ->{
      log.info("{} wins Tie Break with SCORE : {} - {}", player.getName(), playerOne.getTieBreak(), playerTwo.getTieBreak());
    });
    this.reset();
    return optionalPlayer;
  }

  private void reset(){
    playerOne.setTieBreak(0);
    playerTwo.setTieBreak(0);
  }

}
