import processing.core.PApplet;

/**
 * This project is a remake of my old project BrickBreaker. This version of the game will include
 * multiple stages, and will include a stage editor. There will also be setting to change the
 * controls of the bounce bar. This version of the project will also be more organized and use
 * better management of classes with Object Oriented Programming in mind.
 * <p>
 * The game will be a brick breaker game where a ball is bounced between a bounce bar and bricks.
 * Players will control the bounce bar in order to keep the ball above the bounce bar and try to hit
 * all the bricks in order to clear the game.
 *
 * @author Jimmy Li
 * @version 2.0
 * @since 2021-1-28
 */
public class TempGame extends PApplet {

  //////////////////////////////////////////////////////////////////////////////////////////////////
  //PApplet setup
  //////////////////////////////////////////////////////////////////////////////////////////////////
  public static void main(String[] args) {
    PApplet.main("TempGame", args);
  }

  private int gameWidth = 1280;
  private int gameHeight = 720;
  private boolean running = true;

  @Override
  public void settings() {
    size(gameWidth, gameHeight);
  }

  @Override
  public void setup() {
  }

  @Override
  public void draw() {
    if (running) {
    background(255);
    drawDeathBar();
    drawBall();
    drawScore();
    drawMousePos();
    line(gameWidth / 2, gameHeight / 2, gameWidth / 2 + 100 * cos(radians(ballAngle)),
        gameHeight / 2 - 100 * sin(radians(ballAngle)));
    } else {
      stop();
    }
  }

  @Override
  public void stop() {
    System.out.println("Thank you for Playing!");
    exit();
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  //Score
  //////////////////////////////////////////////////////////////////////////////////////////////////
  private int score = 0;

  private void drawScore() {
    score += 1;
    text("score: " + score, 0, 10);
    fill(0);
  }

  private void drawMousePos() {
    text("MouseX:" + mouseX + ", MouseY:" + mouseY, 0, 20);
    fill(0);
  }



  //////////////////////////////////////////////////////////////////////////////////////////////////
  //Ball
  //////////////////////////////////////////////////////////////////////////////////////////////////
  private float ballX = 100;
  private float ballY = 100;
  private int ballR = 10;
  private float ballAngle = -45;
  private int ballSpeed = 50;

  private void drawBall() {
    circle(ballX, ballY, ballR);
    while (ballAngle >= 360) {
      ballAngle -= 360;
    }
    while (ballAngle < 0) {
      ballAngle += 360;
    }
    for (int i = 0; i < ballSpeed; i++) {
      ballX += getXMove(ballAngle);
      ballY += getYMove(ballAngle);
      checkCollision();
    }
  }

  private void checkCollision() {
    if (ballX > gameWidth - 5 && (ballAngle > 270 || ballAngle < 90)) {
      ballAngle = 180 - ballAngle;
    }
    if (ballX < 5 && (ballAngle > 90 && ballAngle < 270)) {
      ballAngle = 180 - ballAngle;
    }
    if (ballY <0 && (ballAngle > 0 && ballAngle < 180)) {
      ballAngle = 360 - ballAngle;
    }
    checkDeathBarCollision();
  }

  private float getXMove(float angle) {
    int sign = (int) (cos(radians(ballAngle)) / abs(cos(radians(ballAngle))));
    return sign * pow(cos(radians(ballAngle)), 2);
  }

  private float getYMove(float angle) {
    int sign = (int) (sin(radians(ballAngle)) / abs(sin(radians(ballAngle))));
    return -sign * pow(sin(radians(ballAngle)), 2);
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  //Death Bar
  //////////////////////////////////////////////////////////////////////////////////////////////////
  private int deathBarHeight = 10;
  private void drawDeathBar() {
    rect(0f, (float)(gameHeight - deathBarHeight), (float)(gameWidth), (float)(gameHeight));
  }
  private void checkDeathBarCollision() {
    if (ballY > gameHeight - deathBarHeight) {
      running = false;
    }
  }

}