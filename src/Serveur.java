import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            CalculatriceInterf calculatrice = new CalculatriceImpl();
            Naming.rebind("rmi://localhost:1099/CalculatriceInterf", calculatrice);
            System.out.println("Serveur prêt !");
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
