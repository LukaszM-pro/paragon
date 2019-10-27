package space;

public class Pole implements Comparable{
    private final int X;
    private final int Y;
    private final int Z;
    private final int XY;
    private final int XZ;
    private final int YZ;
    private final int XYZ;

    public Pole(int x, int y, int z) {
        X = x;
        Y = y;
        Z = z;
        XY = x+y;
        XZ = x+z;
        YZ = y+z;
        XYZ = x+y+z;
    }

    public int x() {
        return X;
    }
    public int y() {
        return Y;
    }
    public int z() {
        return Z;
    }
    public int xy() {
        return XY;
    }
    public int xz() {
        return XZ;
    }
    public int yz() {
        return YZ;
    }
    public int xyz() {
        return XYZ;
    }

    @Override
    public String toString() {
        return "("+X+","+Y+","+Z+")";
    }

    @Override
    public int compareTo(Object o) {
        if (o.getClass().isAssignableFrom(Pole.class)) {
            throw new RuntimeException("Compared object is not of Pole class or it's children.");
        }
        Pole p = (Pole) o;
        if (this.X != p.x()) {
            return this.X - p.x();
        } else if (this.Y != p.y()) {
            return this.Y - p.y();
        } else if (this.Z != p.z()) {
            return this.Z - p.z();
        } else {
            return 0;
        }
    }
}
