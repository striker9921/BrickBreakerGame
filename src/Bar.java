public class Bar implements GameItem{

  private float posX;
  private float posY;
  private float width;
  private float height;

  private float aim;
  private boolean invertControl;

  public Bar(boolean invertControl) {
    this.aim = 0;
    this.posX = 0;
    this.invertControl = invertControl;
  }

  public void update(char key) {
    if(invertControl) {
      posX = Game.processing.mouseX + width/2;

    } else {
      aim = getAim(Game.processing.mouseX, Game.processing.mouseY);
    }
  }

  private float getAim(float mouseX, float mouseY) {
    float center = posX + width/2;

    float x = mouseX - center;
    float y = mouseY - posY;

    return (float)Math.atan(y/x);
  }

  public void setInvertControl(boolean invertControl) {
    this.invertControl = invertControl;
  }

  @Override
  public float[] getPos() {
    return new float[] {posX, posY};
  }

  @Override
  public float[] getCenter() {
    return new float[] {posX + width / 2, posY + height / 2};
  }

  @Override
  public void update() {

  }

  @Override
  public void draw() {

  }
}
