import java.util.Arrays;
import java.util.List;

public class DemoToArrayMethod {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Cheetah", "Red Panda", "Snow Leopard", "Classic Meerkat");

        // old way
        String[] array1 = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(array1));

        // new way
        String[] array2 = list.toArray(String[]::new);
        System.out.println(Arrays.toString(array2));

    }
    
}
