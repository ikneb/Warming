/**
 * Created by Benki on 18.02.2016.
 */
public class ExtrudedPolystyrene extends Warm {

   static final double quadratureOnePolyst = 0.72;


    public ExtrudedPolystyrene(int quadrature, int dopth, int density) {
        super(quadrature, dopth, density);
    }


    public double price(double quadrature,int depth) {
        double price = 0;
        if(depth == 3){
            price = quadrature*330;
        }else if(depth == 5){
            price = quadrature*360;
        }
        return price;
    }

    @Override
    public double quantity(double quadrature) {
        double quantity = quadrature * quadratureOnePolyst;
        return quantity;
    }
}
