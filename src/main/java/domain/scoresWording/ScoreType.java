package domain.scoresWording;
import java.util.Optional;
import java.util.OptionalInt;

public enum  ScoreType {
  ZERO("0", 0),
  FIFTEEN("15", 1),
  THIRTEEN("30", 2),
  FOURTEEN("40",3),
  WINNER_POINT("WINNER_POINT",4);

  ScoreType(String scoreWording, int score){
    this.scoreWording = scoreWording;
    this.score = score;
  }

  private int score;
  private String scoreWording;

  public static Optional<String> getScoreTypeBy(int score) {
    for (ScoreType scoreType : values()) {
      if (scoreType.score == score) {
        return Optional.of(scoreType.scoreWording);
      }
    }
    return Optional.empty();
  }

}
