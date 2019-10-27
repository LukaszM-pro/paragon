package space.abstractFactory;

import java.lang.reflect.InvocationTargetException;

public class Manufakturka<T> {
    private Class<T> clazz;

    public Manufakturka(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T buildOne(int x, int y, int z) {
        T result = null;
        Class classToLoad = clazz;
        Class[] cArg = new Class[3]; //Our constructor has 3 arguments
        cArg[0] = int.class; //First argument is of *object* type Long
        cArg[1] = int.class; //Second argument is of *object* type String
        cArg[2] = int.class; //Third argument is of *primitive* type int
        try {
//        return clazz.newInstance();
            result = (T) classToLoad.getDeclaredConstructor(cArg).newInstance(x, y, z);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//            System.out.print("Mój błąd!");
            e.printStackTrace();
        }
        return result;
    }
}
