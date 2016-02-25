/**
 * Created by Benki on 18.02.2016.
 */
public class Warm implements ConstructionMaterial {
    double quadrature;
    int depth;
    int density;

    public Warm(int quadrature,int depth, int density) {
        this.quadrature = quadrature;
        this.depth = depth;
        this.density = density;
    }


    public double price(double quadrature,int depth, int density) {

        return 0;
    }


    @Override
    public double quantity(double quadrature) {

        return 0;
    }

    @Override
    public void buying() {

    }
}
