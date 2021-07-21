import java.util.stream.Stream;

public class Prob3 {
    public static void main(String[] args) {
        Stream<String> nameStream = Stream.of("mohan", "john", "vaibhav", "amit");
        nameStream.filter(s -> s.startsWith("a"))
                    .forEach(System.out::println);
    }
}
