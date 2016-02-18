/**
 * Created by Benki on 18.02.2016.
 */
public interface Warm extends ConstructionMaterial {
    int density = 0;

    @Override
    double price();

    @Override
    int quantity();

    @Override
    void buying();
}
