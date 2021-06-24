import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfacePartServer extends Remote {

	
	String getNome() throws RemoteException;
	Part AdicionaRecipe(String nome, String[] recipeString, String NomeMaterial) throws RemoteException;
	String consultaRecipes();
	Part ProcuraRecipe(String nome);
	Part MontaRecipe(String nome,int[] codigodaspecasusadas);
	Part MontaRecipe(int id,int[] codigodaspecasusadas) ;
	
}