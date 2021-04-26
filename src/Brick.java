public class Brick implements GameItem{

  private final float width = 116;
  private final float height = 60;

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
    return new float[] {posX + width / 2, posY + height / 2};
  }

  public boolean isHit() {
    return isHit;
  }

  @Override
  public void update() {

  }

  @Override
  public void draw() {
    if(!isHit) {
      Game.processing.rect(posX, posY, width, height);
      Game.processing.fill(0);
    }

  }

}
