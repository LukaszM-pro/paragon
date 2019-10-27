package space.population.myExceptions;

public class PositionChangedByTurnAroundException extends RuntimeException {
    public PositionChangedByTurnAroundException(String msg){
        super(msg);
    }
}