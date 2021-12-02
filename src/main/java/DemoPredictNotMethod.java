import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DemoPredictNotMethod {

    public static void main(String[] args) {

        List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
        List<String> withoutBlanks = sampleList.stream()
                            .filter(Predicate.not(String::isBlank))
                            .collect(Collectors.toList());
        assertThat(withoutBlanks).containsExactly("Java", "Kotlin");
    }

}
