import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfacePartServer extends Remote {

	void AdicionaRecipe() throws RemoteException;
	String getNome() throws RemoteException;
}