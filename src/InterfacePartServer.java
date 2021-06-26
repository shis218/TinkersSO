import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfacePartServer extends Remote {

	
	String getNome() throws RemoteException;
	Part AdicionaRecipe(String nome, String[] recipeString, String NomeMaterial) throws RemoteException;
	String consultaRecipes() throws RemoteException;
	Part ProcuraRecipe(String nome) throws RemoteException;
	Part MontaRecipe(String nome,int[] codigodaspecasusadas) throws RemoteException;
	Part MontaRecipe(int id,int[] codigodaspecasusadas) throws RemoteException;
	
}