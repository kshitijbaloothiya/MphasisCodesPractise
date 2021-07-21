import java.util.stream.Stream;

public class Prob2 {
    public static void main(String[] args){
        Stream<String> nameStream  = Stream.of("mohan","john","vaibhav","amit");
        nameStream.forEach(System.out::println);
    }
}
