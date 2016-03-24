package Entity;

/**
 * Created by Benki on 18.02.2016.
 */
public class MineralWool extends Warm {

    static final double quadratureMinWool = 0.6;
    public int depth;




    public double price(double quadrature, int depth) {
        double price =0;
        if(depth==5)price = quadrature*320;
        if(depth==100)price = quadrature*360;
        return  price;

    }

    @Override
    public double quantity(double quadrature) {

        double quantity = quadrature * quadratureMinWool;

        return quantity;
    }
}
