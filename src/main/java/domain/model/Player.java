package domain.model;


import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {

  // name of the player
  @NotBlank
  private String name;

  // score of the player
  private int score;

  // score of the player
  private int gameWon;

  // tie break of the player
  private int tieBreak;

}
