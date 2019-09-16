package factoryblocks.util;

import net.minecraft.util.math.AxisAlignedBB;

public class HitBox {

  public static final AxisAlignedBB createHitBox(int positionX, int positionY, int positionZ, int sizeX, int sizeY,
      int sizeZ) {

    double x1 = (double) positionX / 16;
    double y1 = (double) positionX / 16;
    double z1 = (double) positionX / 16;
    double x2 = (double) sizeX / 16 + x1;
    double y2 = (double) sizeY / 16 + y1;
    double z2 = (double) sizeZ / 16 + z1;

    return new AxisAlignedBB(x1, y1, z1, x2, y2, z2);
  }
}
