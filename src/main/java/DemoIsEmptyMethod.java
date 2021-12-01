import java.util.Optional;

public class DemoIsEmptyMethod {
    
    public static void main(String[] args) {

        Optional<String> str = Optional.of("test");
        System.out.println(str.isEmpty());

    }
    
}
