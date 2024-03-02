import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            CalculatriceInterf calculatrice = (CalculatriceInterf) Naming.lookup("rmi://localhost:1099/CalculatriceInterf");

            Scanner scanner = new Scanner(System.in);
            String choix;
            do {
                System.out.println("Choisissez une opération :");
                System.out.println("1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.print("Votre choix : ");
                choix = scanner.nextLine();

                double a, b;
                System.out.print("Entrez le premier nombre : ");
                a = scanner.nextDouble();
                System.out.print("Entrez le deuxième nombre : ");
                b = scanner.nextDouble();

                double resultat;
                switch (choix) {
                    case "1":
                        resultat = calculatrice.addition(a, b);
                        break;
                    case "2":
                        resultat = calculatrice.soustraction(a, b);
                        break;
                    case "3":
                        resultat = calculatrice.multiplication(a, b);
                        break;
                    case "4":
                        resultat = calculatrice.division(a, b);
                        break;
                    default:
                        System.out.println("Choix invalide !");
                        resultat = 0;
                }
                System.out.println("Résultat : " + resultat);

                scanner.nextLine(); // Pour vider la ligne restante
                System.out.print("Voulez-vous continuer (oui/non) ? ");
                choix = scanner.nextLine();
            } while (choix.equalsIgnoreCase("oui"));
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
