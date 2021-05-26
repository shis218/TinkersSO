
public class Parts {
private int ingameID; //Codigo fixo definido pelo protocolo,desta forma pe�as do mesmo tipo tem o mesmo ID. � definida no construtor e pode apenas ser consultada

private Materiais materialTrait; //De qual material � primariamente feito essa parte, ela influencia nas caracteristicas de um item processado

private int codigoDestaPeca; //Codigo desta pe�a gerado na inicializa��o, cuidado, maquinas diferentes podem gerar o mesmo codigo
private String nome; //String do nome desta pe�a, n�o � possivel alterar seu nome ap�s criada
private String[] recipeString; //String dos Subcomponentes(Em blocos/itens/outras partes) necessarios pra fazer esta pe�a
private int[] recipeIDs; //Numero de InGameIDs do recipe

private boolean existe;  //A pe�a existe e tem dados atrelados a ela
private int[] codigoDasPe�asUsadas;  //Caso a parte seja criada, ent�o deve colocar quais 'codigoDestaPeca'/'codigoDesteBloco'/'CodigoDesteItem' foram usadas pra completar a recipe


//Getter-setters
public int getIngameID() {
	return ingameID;
}

public int getCodigoDestaPeca() {
	return codigoDestaPeca;
}

public String getNome() {
	return nome;
}


public String[] getRecipeString() {
	return recipeString;
}

public void setRecipeString(String[] recipeString) {
	this.recipeString = recipeString;
}

public int[] getRecipeIDs() {
	return recipeIDs;
}

public void setRecipeIDs(int[] recipeIDs) {
	this.recipeIDs = recipeIDs;
}

public int[] getCodigoDasPe�asUsadas() {
	return codigoDasPe�asUsadas;
}


//Se n�o existe, � apenas um recipe
public boolean getExiste() {
	return this.existe;
}

//Construtor: N�o � o item criado
public Parts(int ingameID, String nome, String[] recipeString, int[] recipeIDs,Materiais material) {
	super();
	this.ingameID = ingameID;
	this.nome = nome;
	this.recipeString = recipeString;
	this.recipeIDs = recipeIDs;
	this.existe=false;
	this.materialTrait=material;
}
//Monta item, lembre de consumir/destruir uma unidade de cada Id usado. Isto define que o item existe
public boolean Monta(int CodigoDestaPe�a,int[] codigoDasPe�asUsadas) {
	if(existe==false) {
		this.existe=true;
		this.codigoDestaPeca=CodigoDestaPe�a;
		this.codigoDasPe�asUsadas=codigoDasPe�asUsadas;
		return true;
	}
	//Se j� existir, ele n�o cria
	return false;
}


//Caso voc� j� esteja com uma Part montada(ou seja, j� possui um codigo desta pe�a/itens usados) ent�o utilize esse metodo de clonar a receita da Part
public Parts clonaRecipe() {
	Parts ret=new Parts(this.ingameID,this.nome,this.recipeString,this.recipeIDs,this.materialTrait);
	return ret;
}



public Parts clonaItem(int novoCodigoDePe�a,int[] codigoDasPe�asUsadas) {
	Parts ret=clonaRecipe();
	ret.Monta(novoCodigoDePe�a,codigoDasPe�asUsadas);
	return ret;
}

public Blocos transformaEmBloco() {
	if(existe==true) {
		//Cria bloco utilizando esse mesmo ID(Caso seja feito em um part repository, consultar se existe uma vers�o bloco)
		Blocos b=new Blocos(ingameID,codigoDestaPeca,nome);		
		//Deleta existencia da pe�a, no entanto sua Recipe � mantida e pode ser usada novamente para montagem
		codigoDestaPeca=-1;
		existe=false;
		return b;
	}
	return null; //Caso nao seja uma Part existindo, nao da pra gerar o bloco nem consumir a recipe
}


}
