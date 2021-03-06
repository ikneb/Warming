package Entity;

/**
 * Created by Benki on 18.02.2016.
 */
public class Styrofoam extends Warm {

    static final int quadratureOneStyrof = 1;





    public double price(double quadrature, int depth, int density) {
        double price = 0;

        if (density == 25) {
            if(depth == 5)price = quadrature*300;
            if(depth == 10) price=quadrature*350;
        } else if (density == 35) {
            if(depth == 5)price = quadrature*330;
            if(depth == 10)price = quadrature*360;
        }

        return price;
    }

    @Override
    public double quantity(double quadrature) {

        double quantity = quadrature * quadratureOneStyrof;

        return quantity;
    }
}
