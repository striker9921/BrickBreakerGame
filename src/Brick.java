public class Brick implements GameItem{

  private final float width = 118;
  private final float height = 62;

  private float posX;
  private float posY;

  private boolean isHit;

  public Brick(float posX, float posY) {
    this.posX = posX;
    this.posY = posY;
    this.isHit = false;
  }

  public float[] getPos() {
    return new float[] {posX, posY};
  }

  @Override
  public float[] getCenter() {
    return new float[0];
  }

  public boolean isHit() {
    return isHit;
  }

  @Override
  public void update() {

  }

  @Override
  public void draw() {

  }

}
