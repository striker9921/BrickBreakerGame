import processing.core.PApplet;

public class Game extends PApplet {
  //processing basic commands
  public static PApplet processing;
  public static void main(String[] args) { PApplet.main("Game", args); }

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
  }

  @Override
  public void draw() {
    background(255);
    drawBall();
    drawBricks();
    drawBar();

  }

  public void initializeBricks() {
    for(int i = 0; i < 10; i++) {
      for (int j = 0; j < 5; j++) {
        bricks[i][j] = new Brick(50+brickWidth*i, 50+brickHeight*j);
      }
    }
  }

  public void drawBall() {
    ball.update();
    ball.draw();
  }

  public void drawBricks() {
    for(int i = 0; i < 10; i++) {
      for(int j = 0; j < 5; j++) {
        bricks[i][j].update();
        bricks[i][j].draw();
      }
    }
  }

  public void drawBar() {
    bar.update();
    bar.draw();
  }

}