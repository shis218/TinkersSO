package minimoentregavel;

public interface Part {

	//Getter-setters
	int getIngameID();

	int getCodigoDestaPeca();

	String getNome();

	String[] getRecipeString();

	void setRecipeString(String[] recipeString);

	int[] getRecipeIDs();

	void setRecipeIDs(int[] recipeIDs);

	int[] getCodigoDasPe�asUsadas();

	//Se n�o existe, � apenas um recipe
	boolean getExiste();

	//Monta item, lembre de consumir/destruir uma unidade de cada Id usado. Isto define que o item existe
	boolean Monta(int CodigoDestaPe�a, int[] codigoDasPe�asUsadas);

	//Caso voc� j� esteja com uma Part montada(ou seja, j� possui um codigo desta pe�a/itens usados) ent�o utilize esse metodo de clonar a receita da Part
	Part clonaRecipe();

	Part clonaItem(int novoCodigoDePe�a, int[] codigoDasPe�asUsadas);

	Blocos transformaEmBloco();

}