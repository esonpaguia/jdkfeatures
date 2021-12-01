import java.util.stream.Collectors;

public class DemoStringMethods {
    
    public static void main(String[] args) {

        String str = "";
        System.out.println(str.isBlank());

        str = "Cheetah\nis\nthe\nmost\nawesome\nteam";
        System.out.println(str);
        System.out.println(str.lines().collect(Collectors.toList()));

        char c = '\u0021';
        str = c + str + c;
        System.out.println(str.strip());
        System.out.println(str.stripLeading());
        System.out.println(str.stripTrailing());

        System.out.println("-".repeat(100));

    }

}