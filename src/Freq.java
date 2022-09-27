import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Freq implements Command {
    public static void freq(String path) throws IOException
    {
        Path File = Paths.get(path);
        String text = Files.readString(File);
        text = text.toLowerCase();
        text = text.replaceAll("\\s+", " ").replaceAll("[^a-z0-9 ]", "");
        Stream <String> words = Arrays.stream(text.split(" ")).filter(word -> !word.isEmpty());
        Map<String, Long> wordCount = words.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        wordCount.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(3).forEach(entry -> System.out.print(entry.getKey() + " "));
        System.out.println("\n");


    }
    ///home/bien_sur/Documents/Epita/Programmes/Java/java_exercise_1/text.txt

    public String name()
    {
        return "freq";
    }

    public boolean run(Scanner scanner)
    {
        System.out.println("Renseignez le chemin vers votre fichier: ");
        String path = scanner.nextLine();
        try {
            freq(path);
        } catch (IOException e) {
            System.out.println("Unreadable file: " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        return false;
    }
}