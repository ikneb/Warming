package Entity;

import Entity.ExtrudedPolystyrene;
import Entity.MineralWool;

/**
 * Created by Benki on 12.03.2016.
 */


public class QuantityMaterial {
    int warm;
    int quadrature;
    static double quantity;
    int glue;
    int putti;
    int grid;
    int paint;

    QuantityMaterial(int warm, int quadrature) {
        this.warm = warm;
        this.quadrature = quadrature;
    }

    //количество утеплителя
    public int quantityWarm() {

        if (warm == 1) {                         //пенопласт
            quantity = quadrature;
        } else if (warm == 2) {                     //пенополистирол

            quantity = (quadrature / ExtrudedPolystyrene.quadratureOnePolyst) + 1;
        } else if (warm == 3) {                                             //вата
            quantity = (quadrature / MineralWool.quadratureMinWool) + 1;

        }
        return (int) quantity;
    }

    public int glue() {          //клей

        return quadrature / 7;
    }

    public int putti() {        //шпаклевка
        return quadrature / 7;
    }

    public int qrid(){          //сетка
        return quadrature;
    }

    public  int paint(){
        return quadrature/4;
    }

}
