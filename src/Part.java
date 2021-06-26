import java.rmi.*;
public interface Part extends Remote {

	//Getter-setters
	int getIngameID() throws RemoteException;

	int getCodigoDestaPeca() throws RemoteException;

	String getNome() throws RemoteException;
	
	Material getMaterial() throws RemoteException;

	String[] getRecipeString() throws RemoteException;

	void setRecipeString(String[] recipeString) throws RemoteException;

	int[] getRecipeIDs() throws RemoteException;

	void setRecipeIDs(int[] recipeIDs) throws RemoteException;

	int[] getCodigoDasPeçasUsadas() throws RemoteException;

	//Se não existe, é apenas um recipe
	boolean getExiste() throws RemoteException;

	//Monta item, lembre de consumir/destruir uma unidade de cada Id usado. Isto define que o item existe
	boolean Monta(int CodigoDestaPeça, int[] codigoDasPeçasUsadas) throws RemoteException;

	//Caso você já esteja com uma Part montada(ou seja, já possui um codigo desta peça/itens usados) então utilize esse metodo de clonar a receita da Part
	Part clonaRecipe() throws RemoteException;

	Part clonaItem(int novoCodigoDePeça, int[] codigoDasPeçasUsadas) throws RemoteException;

	Bloco transformaEmBloco() throws RemoteException;
	
}