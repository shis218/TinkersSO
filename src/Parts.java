
import java.io.Serializable;
import java.rmi.*;

import java.rmi.server.*;

import java.rmi.registry.*;

import java.util.ArrayList;

import minimoentregavel.parts;
public class Parts implements Part, Serializable {
int count=0;
private int ingameID; //Codigo fixo definido pelo protocolo,desta forma peças do mesmo tipo tem o mesmo ID. É definida no construtor e pode apenas ser consultada

private Material materialTrait; //De qual material é primariamente feito essa parte, ela influencia nas caracteristicas de um item processado

private int codigoDestaPeca; //Codigo desta peça gerado na inicialização, cuidado, maquinas diferentes podem gerar o mesmo codigo
private String nome; //String do nome desta peça, não é possivel alterar seu nome após criada
private String[] recipeString; //String dos Subcomponentes(Em blocos/itens/outras partes) necessarios pra fazer esta peça
private int[] recipeIDs; //Numero de InGameIDs do recipe

private boolean existe;  //A peça existe e tem dados atrelados a ela
private int[] codigoDasPeçasUsadas;  //Caso a parte seja criada, então deve colocar quais 'codigoDestaPeca'/'codigoDesteBloco'/'CodigoDesteItem' foram usadas pra completar a recipe


	
	//Getter-setters
	public Material getMaterial() {
		return this.materialTrait;
	}
	
	@Override
	public int getIngameID() {
		return ingameID;
	}

	@Override
	public int getCodigoDestaPeca() {
		return codigoDestaPeca;
	}

	@Override
	public String getNome() {
		return nome;
	}


	@Override
	public String[] getRecipeString() {
		return recipeString;
	}

	@Override
	public void setRecipeString(String[] recipeString) {
		this.recipeString = recipeString;
	}

	@Override
	public int[] getRecipeIDs() {
		return recipeIDs;
	}

	@Override
	public void setRecipeIDs(int[] recipeIDs) {
		this.recipeIDs = recipeIDs;
	}

	@Override
	public int[] getCodigoDasPeçasUsadas() {
		return codigoDasPeçasUsadas;
	}


	//Se não existe, é apenas um recipe
	@Override
	public boolean getExiste() {
		return this.existe;
	}

	//Construtor: Não é o item criado
	public Parts(int ingameID, String nome, String[] recipeString, int[] recipeIDs,Material material) throws RemoteException {
		super();
		this.ingameID = ingameID;
		this.nome = nome;
		this.recipeString = recipeString;
		this.recipeIDs = recipeIDs;
		this.existe=false;
		this.materialTrait=material;
	}
	//Monta item, lembre de consumir/destruir uma unidade de cada Id usado. Isto define que o item existe
	@Override
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
	@Override
	public Part clonaRecipe() throws RemoteException {
		Parts ret=new Parts(this.ingameID,this.nome,this.recipeString,this.recipeIDs,this.materialTrait);
		return ret;
	}



	@Override
	public Part clonaItem(int novoCodigoDePeça,int[] codigoDasPeçasUsadas) throws RemoteException {
		Part ret=clonaRecipe();
		try {
			ret.Monta(novoCodigoDePeça,codigoDasPeçasUsadas);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Bloco transformaEmBloco() {
		if(existe==true) {
			//Cria bloco utilizando esse mesmo ID(Caso seja feito em um part repository, consultar se existe uma versão bloco)
			Bloco b=new Blocos(ingameID,codigoDestaPeca,nome);		
			//Deleta existencia da peça, no entanto sua Recipe é mantida e pode ser usada novamente para montagem
			codigoDestaPeca=-1;
			existe=false;
			return b;
		}
		return null; //Caso nao seja uma Part existindo, nao da pra gerar o bloco nem consumir a recipe
	}
	
	
	

	
}
