import java.util.stream.Stream;

public class Prob1 {
    public static void main(String[] args){
        Stream<String> nameStream  = Stream.of("mohan","john","vaibhav","amit");
        Stream<String> nameStartJ = nameStream.map(String::toUpperCase)
                                                .peek(e -> System.out.println(e))//peek is used to display
                                                .filter(s -> s.startsWith("J"));
        System.out.println("Calling terminal operation: count");
        long count = nameStartJ.count();
        System.out.println("Count:"+ count);




    }
}
