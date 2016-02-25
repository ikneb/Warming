import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Benki on 18.02.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите квадратуру");
        String quadr = reader.readLine();
        int quadrature = Integer.parseInt(quadr);

        System.out.println("Какой, вы, хотите утеплитель");
        System.out.println("-если пенопласт то введите 1");
        System.out.println("-если пенополистирол введите 2");
        System.out.println("-если минеральная вата 3");
        String heat = reader.readLine();
        int heater = Integer.parseInt(heat);
        if (heater == 1) {
            System.out.println("плотность 25 или 35:");
            String den = reader.readLine();
            int density = Integer.parseInt(den);
            System.out.println("и толщину утеплителя(5 или 10см): ");
            String dep = reader.readLine();
            int depth = Integer.parseInt(dep);
            Styrofoam styrofoam = new Styrofoam(quadrature,depth,density);
            System.out.println("Цена утепления: " + styrofoam.price(quadrature,depth,density));
        } else if (heater == 2){
            System.out.println("Выбирайте толщину утеплителя(3 или 5см): ");
            String dep = reader.readLine();
            int depth = Integer.parseInt(dep);
            ExtrudedPolystyrene extrudedPolystyrene = new ExtrudedPolystyrene(quadrature,depth,0);
            System.out.println("Цена утепления: " + extrudedPolystyrene.price(quadrature,depth));
        }else if(heater == 3){
            System.out.println("Выбирайте толщину утеплителя(5 или 10см): ");
            String dep = reader.readLine();
            int depth = Integer.parseInt(dep);
            MineralWool mineralWool = new MineralWool(quadrature,depth,130);
            System.out.println("Цена утепления: " + mineralWool.price(quadrature,depth));
        }


    }


}
