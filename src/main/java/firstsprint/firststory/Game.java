package firstsprint.firststory;

import domain.model.Player;
import domain.scoresWording.ScoreType;
import java.util.Optional;
import java.util.Random;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class Game {

  private Player playerOne;
  private Player playerTwo;

  public Game(Player playerOne, Player playerTwo) {

    this.playerOne = playerOne;
    this.playerTwo = playerTwo;

  }

  /**
   * Increment score player
   * @param player
   */
  private void scores(Player player){
    player.setScore(player.getScore() + 1);
  }

  /**
   * Reset score to 0 for each player
   */
  private void reset(){
    this.playerOne.setScore(0);
    this.playerTwo.setScore(0);
  }

  /**
   *
   * @return optional game winner : rule to win the game
   */
  private Optional<Player> getGameWinner(){

    if(playerOne.getScore() == 4) {
      return Optional.of(playerOne);
    }

    if(playerTwo.getScore() == 4) {
      return Optional.of(playerTwo);
    }
    return Optional.empty();
  }

  /**
   *
   * @return optional winner game
   */
  public Optional<Player> playGame() {

    int scoringPlayer ;
    Random random = new Random();
    Optional<Player> optionalPlayer;

    while(!(optionalPlayer = getGameWinner()).isPresent()){
      scoringPlayer = random.nextInt(100) ;
      if(scoringPlayer % 2 == 0) {
        this.scores(playerOne);
      } else {
        this.scores(playerTwo);
      }
    }
    String scoreFirstPlayer = ScoreType.getScoreTypeBy(playerOne.getScore()).get();
    String scoreSecondPlayer = ScoreType.getScoreTypeBy(playerTwo.getScore()).get();
    optionalPlayer.ifPresent(player ->{
                    log.info("{} wins the game with SCORE : {} - {}", player.getName(), scoreFirstPlayer, scoreSecondPlayer);
                    player.setGameWon(player.getGameWon()+1);
                             });
    this.reset();
    return optionalPlayer;
  }

  public static void main(String[] args) {

    Player playerOne = Player.builder().score(0).name("Djokovich").build();
    Player playerTwo = Player.builder().score(0).name("Federrer").build();
    Game game = Game.builder().playerOne(playerOne).playerTwo(playerTwo).build();
    game.playGame();

  }
}
