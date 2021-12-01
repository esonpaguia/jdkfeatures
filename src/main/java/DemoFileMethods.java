import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DemoFileMethods {
    
    public static void main(String[] args) {

        Path path;
        
        try {

            path = Files.writeString(Files.createTempFile("test", ".txt"), "Cheetah team is cool");
        
            System.out.println(path);

            String str = Files.readString(path);
            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}