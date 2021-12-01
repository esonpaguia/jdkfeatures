# JDK Features

## Java 9

1. private methods on interfaces - to reuse code across the default and static methods in an interface
2. Immutable collections

    ```java
    import java.utils.*;
    
    public class Demo {
        
        public static void main(String[] args) {
            
            List<String> list = List.of("abc", "xyx", "123");
            Set<String> set = Set.of("abc", "xyz");
            
        }

    }
    ```

3. Stream API Updates
    - takeWhile() - it will take the elements from the stream as long as the Predicate returns true and stops when it returns false
    - dropWhile() - it will keep on dropping the elements as long as the Predicate returns true and when it is false, it will take those elements
    - ofNullable() - use to ignore null values while using methods like flatMap.

    ```java
    import java.util.Arrays;

    public class Demo {

        public static void main(String[] args) {

            List<Integer> list = Arrays.asList(10,40,30,7,18,23,null);

            System.out.println(list.stream().takeWhile(x->x%5).collect(Collectors.toList()));
            System.out.println(list.stream().dropWhile(x->x%5).collect(Collectors.toList()));
            System.out.println(list.stream().flatMap(x->Stream.ofNullable(x)).collect(Collectors.toList()));

        }
        
    }
    ```

4. Enhanced Try with resource
    - No need to define the resource inside the Try block.

    ```java
    public class Demo {
        
        public static void main(String[] args) {
            
            MyWorker worker = new MyWorker();

            try (worker) {
                worker.doSomething();
            } catch (Exception e) {

            }
            
        }

    }

    class MyWorker implements AutoCloseable {

        MyWorker() {
            System.out.println("Creating the resource");
        }

        public void doSomething() {
            System.out.println("Doing something");
        }

        @Override
        public void close() throws Exception {
            System.out.println("Closing the resource");
        }
    }
    ```

## Java 10

1. var - use to define inferred types. Meaning the type of the variable will be inferred from the type of value we assign to that variable

    ```java
     public class Demo {
        
        public static void main(String[] args) {

            var x = 10;

            var map = new HashMap<String, List<String>>();

            for (var entry : map.entrySet()) {
                var value = entry.getValue();
            }

            Consumer<Integer> l = (i) -> {
                var z = 10;
                System.out.print(i);
            };

            var list = new ArrayList<Integer>();
            list.add(123);

        }

    }
    ```

2. Collections API update
    - create a unmodifiable list or set from a result of a collect method of a stream

  ```java
  import java.util.List;

  public class Demo {
        
        public static void main(String[] args) {

            List<Integer> list = List.of(15, 20, 17, 30);

            List<Integer> newList = list.stream().filter(i -> i % 3 == 0).collect(Collectors.toUnmodifiableList());

        }

  }
  ```

## Java 11

1. New String methods
    - isBlank() - to check if the value is blank or empty
    - lines() - takes a string with new lines and returns it as a stream by splitting the string based on the new lines
    - strip() - Returns a string whose value is this string, with all leading and trailing white space removed.
    - stripLeading() - Returns a string whose value is this string, with all leading white space removed.
    - stripTrailing() - Returns a string whose value is this string, with all trailing white space removed.
    - repeat(int count) - returns a string whose value is the concatenation of given string repeated count times. If the string is empty or count is zero then the empty string is returned.

    ```java
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
    ```

2. New File methods
    - it's now easier to read and write Strings from files.

    ```java
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
    ```

3. isEmpty method
    - isEmpty() method was added to the Optional class

    ```java
    import java.util.Optional;

    public class DemoIsEmptyMethod {
        
        public static void main(String[] args) {

            Optional<String> str = Optional.of("test");
            System.out.println(str.isEmpty());

        }
        
    }
    ```

4. Collection to an Array
    - toArray() method was added in java.util.Collection interface. It makes easier to create an array of the right type from a collection

    ```java
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
    ```

5. Not Predicate Method
    - A static not method has been added to the Predicate interface. We can use it to negate an existing predicate, much like the negate method

    ```java
    import java.util.Predicate;
    import java.util.LisCollectorst;

    public class Demo {
        
        public static void main(String[] args) {

            List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
            List withoutBlanks = sampleList.stream()
                                .filter(Predicate.not(String::isBlank))
                                .collect(Collectors.toList());
                                assertThat(withoutBlanks).containsExactly("Java", "Kotlin");

        }

    }
    ```
## References
- https://www.baeldung.com/java-11-new-features
- https://www.baeldung.com/oracle-jdk-vs-openjdk
- https://docs.oracle.com/en/java/javase/11/docs/api/index.html