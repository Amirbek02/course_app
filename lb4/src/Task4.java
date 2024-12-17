import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        String firstString = "Amiraev Amirbek world";
        String secondString = "Goodbye, world!";
        Map<Character, Integer> frequencyFirst = new HashMap<>();
        for (char ch : firstString.toCharArray()) {
            frequencyFirst.put(ch, frequencyFirst.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> s : frequencyFirst.entrySet()) {
            System.out.println("Символ: " + s.getKey() + " Количество повторов: " + s.getValue());
        }

        Set<Character> first = new HashSet<>();
        first.addAll(frequencyFirst.keySet());
        Set<Character> second = new HashSet<>();
        for(char seconds : secondString.toCharArray()) {
            second.addAll(Collections.singleton(seconds));
        }
        second.removeAll(first);

        System.out.println("Символы входят во вторую и не входят в первую: "+second);



//        Map<String, Integer> word = new HashMap<>();
//
//        for (String ch : firstString.split(" ")) {
//            word.put(ch, word.getOrDefault(ch, 0) + 1);
//        }
//
//        for (Map.Entry<String, Integer> b : word.entrySet()) {
//            System.out.println("Слов: " + b.getKey() + " Количество повторов: " + b.getValue());
//        }


    }
}
