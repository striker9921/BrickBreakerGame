public class Ball implements GameItem{

  private float posX;
  private float posY;
  private float radius;

  @Override
  public float[] getPos() {
    return new float[] {posX, posY};
  }

  @Override
  public float[] getCenter() {
    return new float[] {posX + radius, posY + radius};
  }

  @Override
  public void update() {

  }

  @Override
  public void draw() {
    update();
    Game.processing.circle(posX, posY, radius);
  }

}
