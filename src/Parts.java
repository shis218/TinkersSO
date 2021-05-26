
public class Parts {
private int ingameID; //Codigo fixo definido pelo protocolo,desta forma peças do mesmo tipo tem o mesmo ID. É definida no construtor e pode apenas ser consultada

private Materiais materialTrait; //De qual material é primariamente feito essa parte, ela influencia nas caracteristicas de um item processado

private int codigoDestaPeca; //Codigo desta peça gerado na inicialização, cuidado, maquinas diferentes podem gerar o mesmo codigo
private String nome; //String do nome desta peça, não é possivel alterar seu nome após criada
private String[] recipeString; //String dos Subcomponentes(Em blocos/itens/outras partes) necessarios pra fazer esta peça
private int[] recipeIDs; //Numero de InGameIDs do recipe

private boolean existe;  //A peça existe e tem dados atrelados a ela
private int[] codigoDasPeçasUsadas;  //Caso a parte seja criada, então deve colocar quais 'codigoDestaPeca'/'codigoDesteBloco'/'CodigoDesteItem' foram usadas pra completar a recipe


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

public int[] getCodigoDasPeçasUsadas() {
	return codigoDasPeçasUsadas;
}


//Se não existe, é apenas um recipe
public boolean getExiste() {
	return this.existe;
}

//Construtor: Não é o item criado
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
public boolean Monta(int CodigoDestaPeça,int[] codigoDasPeçasUsadas) {
	if(existe==false) {
		this.existe=true;
		this.codigoDestaPeca=CodigoDestaPeça;
		this.codigoDasPeçasUsadas=codigoDasPeçasUsadas;
		return true;
	}
	//Se já existir, ele não cria
	return false;
}


//Caso você já esteja com uma Part montada(ou seja, já possui um codigo desta peça/itens usados) então utilize esse metodo de clonar a receita da Part
public Parts clonaRecipe() {
	Parts ret=new Parts(this.ingameID,this.nome,this.recipeString,this.recipeIDs,this.materialTrait);
	return ret;
}



public Parts clonaItem(int novoCodigoDePeça,int[] codigoDasPeçasUsadas) {
	Parts ret=clonaRecipe();
	ret.Monta(novoCodigoDePeça,codigoDasPeçasUsadas);
	return ret;
}

public Blocos transformaEmBloco() {
	if(existe==true) {
		//Cria bloco utilizando esse mesmo ID(Caso seja feito em um part repository, consultar se existe uma versão bloco)
		Blocos b=new Blocos(ingameID,codigoDestaPeca,nome);		
		//Deleta existencia da peça, no entanto sua Recipe é mantida e pode ser usada novamente para montagem
		codigoDestaPeca=-1;
		existe=false;
		return b;
	}
	return null; //Caso nao seja uma Part existindo, nao da pra gerar o bloco nem consumir a recipe
}


}
