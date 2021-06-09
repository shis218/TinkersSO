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

	int[] getCodigoDasPeçasUsadas();

	//Se não existe, é apenas um recipe
	boolean getExiste();

	//Monta item, lembre de consumir/destruir uma unidade de cada Id usado. Isto define que o item existe
	boolean Monta(int CodigoDestaPeça, int[] codigoDasPeçasUsadas);

	//Caso você já esteja com uma Part montada(ou seja, já possui um codigo desta peça/itens usados) então utilize esse metodo de clonar a receita da Part
	Part clonaRecipe();

	Part clonaItem(int novoCodigoDePeça, int[] codigoDasPeçasUsadas);

	Blocos transformaEmBloco();

}