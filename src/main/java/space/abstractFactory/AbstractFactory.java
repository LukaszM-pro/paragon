package abstractFactory;

public interface AbstractFactory<GenericType> {
    GenericType create(int x, int y, int z) ;
}
