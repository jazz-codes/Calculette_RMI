import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatriceImpl extends UnicastRemoteObject implements CalculatriceInterf {
    protected CalculatriceImpl() throws RemoteException {
        super();
    }


    public double addition(double a, double b) throws RemoteException {
        return a + b;
    }


    public double soustraction(double a, double b) throws RemoteException {
        return a - b;
    }

    public double multiplication(double a, double b) throws RemoteException {
        return a * b;
    }


    public double division(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Division par zéro !");
        }
        return a / b;
    }
}
