package space;

public class Hex extends Pole {

    private final double _X;
    private final double _Y;
    private final double _Z;

    public Hex(int x, int y, int z) {
        super(x, y, z);
        _X = x+x+y+z;
        _Y = y+y+z;
        _Z = z+z;
    }

    public double _x() {
        return _X;
    }
    public double _y() {
        return _Y;
    }
    public double _z() {
        return _Z;
    }
}
