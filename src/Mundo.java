import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;

import java.rmi.server.*;

import java.rmi.registry.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Mundo implements InterfaceMundo  {
//Mundo é um sistema unico que possui blocos, maquinas, jogadores
//Um mundo é composto por sua estrutura fisica[uma matriz x-y-z] onde blocos são alocados e jogadores 'transitam sobre ele', embora a parte de jogadores não sera implantada fisicamente por enquanto
//Este mundo possui repositorios de partes/blocos/items que são estruturas que podem ser hosteadas em outras portas/computadores	
//Maquinas podem executar ações em Hosts de computadores diferentes
//Um mundo possui uma lista de Ids com Nomes Oficial e unificada, subservidores devem ter uma copia dessa lista ao ligarem com o mundo e são notificados caso tenha alguma adição: 
	
	
//Mundo age como um computador mestre onde clientes(jogadores) se conectam para conseguir informações
//Jogador pode colocar blocos do seu inventario no mundo
	
//Caso a informação já esteja no cliente e ele não precise alterar o mundo, ele pode consultar os repositorios/maquinas que estão em seu cache
//Caso alterações desses repositorios/maquinas causem alteração no mundo e não conseguirem conexão, deve informar erro ao jogador	

//Este mundo é uma instancia unica que pode ser consultada por outros sistemas
//Não é possivel importar coisas de um mundo para outro com perfeição, pois os estados de tabelas vitais podem estar diferentes
//Mundos compativeis caso estados de tabelas sejam iguais quando necessario, para isso utilize o checarCompatibilidade ou então clonar mundo
//Clonagem de  configuração de mundo não importa jogadores nem os blocos ali salvos
	
	
private int[][][] mundo = new int[30][30][30]; //Devido ao tempo de implementação, essa parte não sera implementada
private ArrayList<String[]> nomelistaDeServidoresConhecidos=new ArrayList<String[]>(); //Esses servidores podem ser part builders, part repositories, maquinas
private Registry registry;
private ListaDeIdsENomesOficial lista= new ListaDeIdsENomesOficial();
private ListaDeMateriais materiais=new ListaDeMateriais();

public int adicionaItemNoServer(String Nome) {
	//Esse adiciona item é tanto para Partes/Blocos/Itens, já que a lista deles é unica que é seus Ids-nomes
	
	return lista.AdicionaItem(Nome.toLowerCase()); 
}


public int adicionaMaterialNoServer(String nome,int Headdurabilidade,Encantamento  Headenchant1,Encantamento  Headenchant2,int Partsdurabilidade,Encantamento  Partenchant1,Encantamento  Partenchant2,int handleDurabilidade,float durabilityModifier) {
	
	 
	return materiais.Adiciona(nome.toLowerCase(), Headdurabilidade, Headenchant1, Headenchant2, Partsdurabilidade, Partenchant1, Partenchant2, handleDurabilidade, durabilityModifier);
	
}
public String PrintaMateriais() {
	return materiais.listMats();
}

public String listaItens() {
	return lista.listItems().toString();
}

public ArrayList<String[]> getNomelistaDeServidoresConhecidos() {
	return nomelistaDeServidoresConhecidos;
}

public int getidItem(String nome) {
	if(nome.equals("null")) {
		return -1;
	}
	return lista.getIdByNome(nome);
}


public String getStringItem(int id) {
	if(id==-1) {
		return "null";
	}
	return lista.getNomeByID(id);
}

public int getidMaterial(String nome) {
	if(nome.equals("null")) {
		return -1;
	}
	return materiais.getIdByNome(nome);
}

public String getStringMaterial(int id) {
	if(id==-1) {
		return "null";
	}
	return materiais.getNomeByID(id);
}
public Material getMaterialbyString(String nome) {
	
	if(nome.equals("null")) {
		return null;
	}
	return materiais.getMaterialByNome(nome);
	
}

@Override
public void adicionaPartServer(String Nome, String Funcao) {
    //binda a classe na lista de nomes do server
	String[] partserver=new String[2];
	partserver[0]=Nome.toLowerCase();
	partserver[1]=Funcao;
	nomelistaDeServidoresConhecidos.add(partserver);	
	
}

@Override
public String ProcuraServer(String funcao) {
	ArrayList<Integer> indexPossiveis=new ArrayList<Integer>();
	for(int i=0;i<nomelistaDeServidoresConhecidos.size();i++) {
		if(nomelistaDeServidoresConhecidos.get(i)[1].equals(funcao)) {
			indexPossiveis.add(i);
		}
	}
	
	int resp = (int)(Math.random() * indexPossiveis.size());
	
	
	
	return nomelistaDeServidoresConhecidos.get(resp)[0];
}



public static void main(String[] Args) throws RemoteException, AlreadyBoundException {
	
	Mundo World=new Mundo();
	World.registry= LocateRegistry.getRegistry();
	InterfaceMundo world=(InterfaceMundo) UnicastRemoteObject.exportObject(World, 0);  //Talvez de pra melhorar ao dar bind em outras ports aqui?
	World.registry.rebind("Mundo", world);
	System.out.print("Servidor mundo foi rebindado com sucesso");
	World.MontaListaDeItensInicial(World);
	System.out.println(World.lista.listItems().toString());
}


private void MontaListaDeItensInicial(Mundo World) {
	World.lista.AdicionaItem("Paper"); 
	World.lista.AdicionaItem("Constantan"); 
	World.lista.AdicionaItem("Treated Wood"); 
	World.lista.AdicionaItem("Wood"); 
	World.lista.AdicionaItem("Electrum"); 
	World.lista.AdicionaItem("Stone"); 
	World.lista.AdicionaItem("Obsidian"); 
	World.lista.AdicionaItem("Flint"); 
	World.lista.AdicionaItem("Bone"); 
	World.lista.AdicionaItem("Iron"); 
	World.lista.AdicionaItem("Copper"); 
	World.lista.AdicionaItem("Cactus"); 
	World.lista.AdicionaItem("Silver"); 
	World.lista.AdicionaItem("Netherrack"); 
	World.lista.AdicionaItem("Lead"); 
	World.lista.AdicionaItem("Pig Iron"); 
	World.lista.AdicionaItem("End"); 
	World.lista.AdicionaItem("Bronze"); 
	World.lista.AdicionaItem("Prismarine"); 
	World.lista.AdicionaItem("Steel"); 
	World.lista.AdicionaItem("Firewood"); 
	World.lista.AdicionaItem("Magma Slime"); 
	World.lista.AdicionaItem("Cobalt"); 
	World.lista.AdicionaItem("Blue Slime"); 
	World.lista.AdicionaItem("Manyullyn"); 
	World.lista.AdicionaItem("Knightslime"); 
	World.lista.AdicionaItem("Ardite"); 
	World.lista.AdicionaItem("Slime"); 
	World.lista.AdicionaItem("Sponge"); 
	//String nome,int Headdurabilidade,Encantamento  Headenchant1,Encantamento  Headenchant2,int Partsdurabilidade,Encantamento  Partenchant1,Encantamento  Partenchant2,int handleDurabilidade,float durabilityModifier) {
	World.materiais.Adiciona("paper", 1, null, null, 15, null, null, 5, (float) 0.10);
	World.materiais.Adiciona("constantan", 260, null, null, 444, null, null, 60, (float) 0.80);
	World.materiais.Adiciona("diamante", 1026, null, null, 255, null, null, 600, (float) 1.00);
	World.materiais.Adiciona("madeira", 50, null, null, 55, null, null, 600, (float) 1.20);
	System.out.println(World.materiais.listMats());
}



//Server lists
public  void faznada() {
	/*Furnace*/
	InterfacePartServer furnace;
	/*Workbench*/
	InterfacePartServer Workbench;
	/*Part Tools*/
	InterfacePartServer PartTools;
	/*Tool Forge*/
	InterfacePartServer ToolForge;
}

@Override
public Part geraPart(int id) throws RemoteException {
	//(int ingameID, String nome, String[] recipeString, int[] recipeIDs,ListaDeMateriais material) throws RemoteException 
	Parts pgerada=new Parts(id, lista.getNomeByID(id), null, null, null);
	return pgerada;
	
}

public Item geraItem(int id) throws RemoteException {
	//(int ingameID, String nome, String[] recipeString, int[] recipeIDs,ListaDeMateriais material) throws RemoteException 
	Items igerada=new Items(false, id, null, null, id, null, null);
	return igerada;
	
}
public Bloco geraBloco(int id) throws RemoteException {
	//(int ingameID, String nome, String[] recipeString, int[] recipeIDs,ListaDeMateriais material) throws RemoteException 
	Blocos bgerada=new Blocos(id, id, null);
	return bgerada;
	
}


@Override
public void removeServer(String nome) {
		
		for(int i=0;i<nomelistaDeServidoresConhecidos.size();i++) {
			if(nomelistaDeServidoresConhecidos.get(i)[0].equals(nome)) {
				nomelistaDeServidoresConhecidos.remove(i);
			}
		}
		
		
		return;
	}


@Override
public String listaServers() throws RemoteException {
	StringBuilder resp=new StringBuilder();
	resp.append("Nome---Funcao: \n");
	int numero=0;
	Iterator<String[]> iv=nomelistaDeServidoresConhecidos.iterator();
	resp.append("\n");
	while(iv.hasNext()) {
	String[] a=iv.next();
	resp.append(a[0]+"---"+a[1]+"\n");
	numero++;
	}
	return resp.toString();
}
	








	
}
