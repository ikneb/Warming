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
        System.out.println("Enter your quadrature ");
        String quadr = reader.readLine();
        int quadrature = Integer.parseInt(quadr);

        System.out.println("What do you want a heater");
        System.out.println("-if Styrofoam enter 1");
        System.out.println("-if Extruded Polystyrene enter 2");
        System.out.println("-if MineralWool enter 3");
        String heat = reader.readLine();
        int heater = Integer.parseInt(heat);
        if (heater==1){
            Styrofoam styrofoam = new Styrofoam();

        }

    }

    ArrayList<Integer> priceCostrMaterial = new ArrayList<>();

}
