package Entity;


public class QuantityMaterial {
   public String material;
    public int quadrature;
    public static double quantity;




    //количество утеплителя
    public static int warmQuantity(String material, int quadrature) {

        if (material == "styrofoam") {                         //пенопласт
            quantity = quadrature;
        } else if (material == "expanded_polystyrene") {                     //пенополистирол

            quantity = (quadrature / ExtrudedPolystyrene.quadratureOnePolyst) + 1;
        } else if (material == "mineral_wool") {                                             //вата
            quantity = (quadrature / MineralWool.quadratureMinWool) + 1;

        }
        return (int) quantity;
    }

    public static int glueQuantity(int quadrature) {          //клей

        return quadrature / 7;
    }

    public static int puttiQuantity(int quadrature) {        //шпаклевка
        return quadrature / 7;
    }

    public static int qridQuantity(int quadrature){          //сетка
        return quadrature;
    }

    public static int paintQuantity(int quadrature){
        return quadrature/4;
    }

}

