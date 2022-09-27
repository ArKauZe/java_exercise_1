import java.util.Scanner;

public class Fibo implements Command {
    public static int fibo(int nb)
    {
        if (nb <= 1)
        {
            return nb;
        }
        return fibo(nb - 1) + fibo(nb - 2);
    }
    public String name()
    {
        return "Fibo";
    }
    public boolean run(Scanner scanner)
    {
        System.out.println("Tapez un nombre");
        int nb = Integer.parseInt(scanner.nextLine());
        int fibonacci = Fibo.fibo(nb);
        if (fibonacci < 0)
        {
            System.out.println("Le nombre doit être positif");
        }
        else
        {
            System.out.println("F("+nb+") = " + fibonacci);
        }
        return false;

    }
}
