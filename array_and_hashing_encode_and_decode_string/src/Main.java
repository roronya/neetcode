import java.util.List;

public class Main {
    public static void main(String[] args) {
        var solution = new Solution();
        List<String> input;

        input = List.of("neet","code","love","you");
        System.out.println(solution.decode(solution.encode(input)));

        input = List.of("we", "say", ":", "yes");
        System.out.println(solution.decode(solution.encode(input)));

        input = List.of("The quick brown fox","jumps over the","lazy dog","1234567890","abcdefghijklmnopqrstuvwxyz");
        System.out.println(solution.decode(solution.encode(input)));
    }
}