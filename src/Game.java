import processing.core.PApplet;

/**
 * This project is a remake of my old project BrickBreaker. This version of the game will include
 * multiple stages, and will include a stage editor. There will also be setting to change the
 * controls of the bounce bar. This version of the project will also be more organized and use
 * better management of classes with Object Oriented Programming in mind.
 *
 * The game will be a brick breaker game where a ball is bounced between a bounce bar and bricks.
 * Players will control the bounce bar in order to keep the ball above the bounce bar and try to
 * hit all the bricks in order to clear the game.
 *
 * @author Jimmy Li
 * @version 2.0
 * @since 2021-1-28
 */
public class Game extends PApplet {

  //processing basic setup
  public static PApplet processing;

  public static void main(String[] args) {
    PApplet.main("Game", args);
  }

  private final float brickWidth = 118;
  private final float brickHeight = 62;

  enum State {
    START,
    SETTINGS,
    EDITOR,
    STAGE,
    LOSE,
    WIN
  }

  static State gamestate = State.STAGE;

  Ball ball = new Ball();
  Bar bar = new Bar(false);
  Brick[][] bricks = new Brick[16][5];

  @Override
  public void settings() {
    size(1280, 720);
  }

  @Override
  public void setup() {
    processing = this;
    Ball ball = new Ball();
    Bar bar = new Bar(false);
    Brick[][] bricks = new Brick[16][5];
    initializeBricks();
  }

  @Override
  public void draw() {
    background(255);
    drawBall();
    drawBricks();
    drawBar();
    drawMousePos();
  }

  public void initializeBricks() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 5; j++) {
        bricks[i][j] = new Brick(51 + brickWidth * i, 26 + brickHeight * j);
      }
    }
  }

  public void drawBall() {
    ball.update();
    ball.draw();
  }

  public void drawBricks() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 5; j++) {
        bricks[i][j].update();
        bricks[i][j].draw();
      }
    }
  }

  public void drawBar() {
    bar.update();
    bar.draw();
  }

  private void drawMousePos() {
    text("MouseX:" + mouseX + ", MouseY:" + mouseY, 0, 26);
  }

}