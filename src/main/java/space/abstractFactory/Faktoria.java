package abstractFactory;

import space.Pole;

import java.lang.reflect.InvocationTargetException;

public class Faktoria<GenericTypeExtendingPole extends Pole> {
    public GenericTypeExtendingPole factory(Class<GenericTypeExtendingPole> clazz, int x, int y, int z) {
//        Class classToLoad = getClass();
        Class classToLoad = clazz;
        Class[] cArg = new Class[3]; //Our constructor has 3 arguments
        cArg[0] = int.class; //First argument is of *object* type Long
        cArg[1] = int.class; //Second argument is of *object* type String
        cArg[2] = int.class; //Third argument is of *primitive* type int
        try {
            return (GenericTypeExtendingPole) classToLoad.getDeclaredConstructor(cArg).newInstance(x,y,z);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.print("Mój błąd!");
            e.printStackTrace();
        }
        return null;
    }
}
