package homework1.number3;

public class Square implements GeometricFigure, WithCorners{
    @Override
    public String whoAreYou() {
        return "Квадрат";
    }

    @Override
    public int howManyCorners() {
        return 4;
    }
}
