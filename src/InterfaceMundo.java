import java.util.ArrayList;
import java.rmi.*;
public interface InterfaceMundo extends Remote {

	
	ArrayList<String[]> getNomelistaDeServidoresConhecidos() throws RemoteException;
	void adicionaPartServer(String Nome, String Funcao) throws RemoteException;

	String ProcuraServer(String funcao) throws RemoteException;
	
	Part geraPart(int id) throws RemoteException ;

}