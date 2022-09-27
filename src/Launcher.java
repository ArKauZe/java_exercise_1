import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Launcher  {
    public static void main(String[] args) throws IOException {

        System.out.println("Bonjour");
        Scanner scanner = new Scanner(System.in);
        List<Command> commands = new ArrayList<Command>();
        commands.add(new Freq());
        commands.add(new Fibo());
        commands.add(new Quit());
        while (true) {
            String input = scanner.nextLine();
            boolean found = true;
            boolean result = false;
            for (Command command : commands) {
                if (command.name().equalsIgnoreCase(input)) {
                    found = false;
                    result = command.run(scanner);
                    break;
                }
            }
            if (found) {
                System.out.println("Unknown command");
            }
            if (result) {
                break;
            }
        }
    }
}
