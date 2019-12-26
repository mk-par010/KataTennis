package firstsprint.secondstory;

import domain.model.Player;
import domain.scoresWording.ScoreType;
import firstsprint.firststory.Game;
import java.util.Optional;
import java.util.Random;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Builder
public class GameWithDeuceCase {


  private Player playerOne;
  private Player playerTwo;

  public GameWithDeuceCase(Player playerOne, Player playerTwo) {

    this.playerOne = playerOne;
    this.playerTwo = playerTwo;

  }

  private void scores(Player player){
    player.setScore(player.getScore() + 1);
  }

  /**
   * reset score to 0 for each player
   */
  private void reset(){
    this.playerOne.setScore(0);
    this.playerTwo.setScore(0);
  }

  /**
   *
   * @return winner game : rule to get winner
   */
  private Optional<Player> getGameWinner() {

    int scoreFirstPlayer = playerOne.getScore();
    int scoreSecondPlayer = playerTwo.getScore();

    if (scoreFirstPlayer == 4 && scoreSecondPlayer < 3) {
      return Optional.of(playerOne);
    }

    if (scoreSecondPlayer == 4 && scoreFirstPlayer < 3) {
      return Optional.of(playerTwo);
    }

    if (scoreFirstPlayer >=4 && scoreSecondPlayer >=4) {
      if(scoreFirstPlayer - scoreSecondPlayer == 2){
        return Optional.of(playerOne);
      }
      if(scoreSecondPlayer - scoreFirstPlayer == 2){
        return Optional.of(playerTwo);
      }
    }

    return Optional.empty();
  }

  /**
   *
   * @return winner player
   */
  public Optional<Player> playGame() {

    int scoringPlayer ;
    Random random = new Random();
    String scoreFirstPlayer;
    String scoreSecondPlayer;

    Optional<Player> optionalPlayer;

    while(!(optionalPlayer = getGameWinner()).isPresent()){
      scoringPlayer = random.nextInt(100) ;
      if(scoringPlayer % 2 == 0) {
        this.scores(playerOne);
      } else {
        this.scores(playerTwo);
      }
    }

    if (!ScoreType.getScoreTypeBy(playerOne.getScore()).isPresent() || !ScoreType.getScoreTypeBy(playerTwo.getScore()).isPresent()) {

      if (playerOne.getScore() > playerTwo.getScore()) {
        scoreFirstPlayer  = ScoreType.getScoreTypeBy(4).get();
        scoreSecondPlayer = ScoreType.getScoreTypeBy(3).get();
      } else {
        scoreFirstPlayer  = ScoreType.getScoreTypeBy(3).get();
        scoreSecondPlayer = ScoreType.getScoreTypeBy(4).get();
      }

    } else {
      scoreFirstPlayer  = ScoreType.getScoreTypeBy(playerOne.getScore()).get();
      scoreSecondPlayer = ScoreType.getScoreTypeBy(playerTwo.getScore()).get();
    }

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
    Game game = new Game(playerOne, playerTwo);
    game.playGame();
  }

}
