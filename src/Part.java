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

	int[] getCodigoDasPe�asUsadas() throws RemoteException;

	//Se n�o existe, � apenas um recipe
	boolean getExiste() throws RemoteException;

	//Monta item, lembre de consumir/destruir uma unidade de cada Id usado. Isto define que o item existe
	boolean Monta(int CodigoDestaPe�a, int[] codigoDasPe�asUsadas) throws RemoteException;

	//Caso voc� j� esteja com uma Part montada(ou seja, j� possui um codigo desta pe�a/itens usados) ent�o utilize esse metodo de clonar a receita da Part
	Part clonaRecipe() throws RemoteException;

	Part clonaItem(int novoCodigoDePe�a, int[] codigoDasPe�asUsadas) throws RemoteException;

	Bloco transformaEmBloco() throws RemoteException;
	
}