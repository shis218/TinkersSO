import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;

import java.rmi.server.*;

import java.rmi.registry.*;

import java.util.ArrayList;

public class Mundo implements InterfaceMundo  {
//Mundo � um sistema unico que possui blocos, maquinas, jogadores
//Um mundo � composto por sua estrutura fisica[uma matriz x-y-z] onde blocos s�o alocados e jogadores 'transitam sobre ele', embora a parte de jogadores n�o sera implantada fisicamente por enquanto
//Este mundo possui repositorios de partes/blocos/items que s�o estruturas que podem ser hosteadas em outras portas/computadores	
//Maquinas podem executar a��es em Hosts de computadores diferentes
//Um mundo possui uma lista de Ids com Nomes Oficial e unificada, subservidores devem ter uma copia dessa lista ao ligarem com o mundo e s�o notificados caso tenha alguma adi��o: 
	
	
//Mundo age como um computador mestre onde clientes(jogadores) se conectam para conseguir informa��es
//Jogador pode colocar blocos do seu inventario no mundo
	
//Caso a informa��o j� esteja no cliente e ele n�o precise alterar o mundo, ele pode consultar os repositorios/maquinas que est�o em seu cache
//Caso altera��es desses repositorios/maquinas causem altera��o no mundo e n�o conseguirem conex�o, deve informar erro ao jogador	

//Este mundo � uma instancia unica que pode ser consultada por outros sistemas
//N�o � possivel importar coisas de um mundo para outro com perfei��o, pois os estados de tabelas vitais podem estar diferentes
//Mundos compativeis caso estados de tabelas sejam iguais quando necessario, para isso utilize o checarCompatibilidade ou ent�o clonar mundo
//Clonagem de  configura��o de mundo n�o importa jogadores nem os blocos ali salvos
	
	
private int[][][] mundo = new int[30][30][30];
private ArrayList<String[]> nomelistaDeServidoresConhecidos=new ArrayList<String[]>(); //Esses servidores podem ser part builders, part repositories, maquinas
Registry registry;
ListaDeIdsENomesOficial lista= new ListaDeIdsENomesOficial();
ListaDeMateriais materiais=new ListaDeMateriais();
@Override
public ArrayList<String[]> getNomelistaDeServidoresConhecidos() {
	return nomelistaDeServidoresConhecidos;
}

@Override
public void adicionaPartServer(String Nome, String Funcao) {
    //binda a classe na lista de nomes do server
	String[] partserver=new String[2];
	partserver[0]=Nome;
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
	InterfaceMundo world=(InterfaceMundo) UnicastRemoteObject.exportObject(World, 0);
	World.registry.rebind("Mundo", world);
	System.out.print("Servidor mundo foi rebindado com sucesso");
	World.MontaListaDeItensInicial(World);
	System.out.println(World.lista.listItems().toString());
}


public void MontaListaDeItensInicial(Mundo World) {
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
	World.materiais.Adiciona("Paper", 12, null, null, 15, null, null, 5, (float) 0.10);
	World.materiais.Adiciona("Constantan", 26, null, null, 6, null, null, 6, (float) 0.80);
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

	
}
