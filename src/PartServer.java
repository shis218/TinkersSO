
import java.io.Serializable;
import java.rmi.*;

import java.rmi.server.*;

import java.rmi.registry.*;

import java.util.ArrayList;
import java.util.Iterator;

import minimoentregavel.parts;
public class PartServer implements Remote, InterfacePartServer, Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 8987587619729336852L;
int count=0;
private String nome; //Nome desse server no registry
ArrayList<Parts> vecParts=new ArrayList<Parts>();
InterfaceMundo mundo;


public String getNome() {
	return this.nome;
}




public  PartServer(String nome,String function,Registry registry) throws AccessException, RemoteException, NotBoundException, AlreadyBoundException {	
	super();
	this.nome=nome;
	mundo= (InterfaceMundo) registry.lookup("Mundo");
	InterfacePartServer partServ=(InterfacePartServer) UnicastRemoteObject.exportObject(this, 0);
	registry.rebind(nome.toLowerCase(), partServ);
	mundo.adicionaPartServer(nome, function);
}

	public Parts AdicionaRecipe(String nome, String[] recipeString, String NomeMaterial) throws RemoteException{
		//int ingameID, String nome, String[] recipeString, int[] recipeIDs,Material material
		int ingameID = mundo.adicionaItemNoServer(nome);  //Devolve o ingame ID, se for novo ele devolve o novo ID e esta persistido no mundo, se for velho devolve apenas o id antigo
		int[] recipeIDS=new int[9];
		for(int i=0;i<9;i++) {
			recipeIDS[i]=mundo.getidItem(recipeString[i]);  //Procura ID por nome do recipe
			
		}
		Material m=mundo.getMaterialbyString(NomeMaterial);
		Parts p=new Parts(ingameID,nome, recipeString, recipeIDS,m);
		//Adiciona na lista e depois devolve essa parte como resposta
		vecParts.add(p);
		System.out.println("\n Adicionando ids:"+recipeIDS[0]+ "-"+recipeIDS[1]+"-");
		return p;
	}




	@Override
	public String consultaRecipes() {
		StringBuilder resp=new StringBuilder();
		int numero=0;
		Iterator<Parts> iv=vecParts.iterator();
		resp.append("\n");
		while(iv.hasNext()) {
		resp.append(numero+" - "+iv.next().getNome()+"\n");
		numero++;
		}
		return resp.toString();
	}




	@Override
	public Part ProcuraRecipe(String Nome) {
		Iterator<Parts> iv=vecParts.iterator();
		int count=0;
		while(iv.hasNext()) {
			if(iv.next().getNome().equals(Nome)) {
				return vecParts.get(count); //Encontrou e devolve a classe Part dentro do vector
				
			}
			count++;
				
		}
		
		
		return null;
	}




	@Override
	public Part MontaRecipe(String Nome,int[] codigodaspecasusadas) {
		Iterator<Parts> iv=vecParts.iterator();
		int count=0;
		while(iv.hasNext()) {
			if(iv.next().getNome().equals(Nome)) {
				Parts a=vecParts.get(count);
				int id=a.getCodigoDestaPeca();
				a.Monta(id, codigodaspecasusadas);
				return vecParts.get(count); //Encontrou e devolve a classe Part montada dentro do vector
				
			}
			count++;
				
		}
		
		
		return null;
	
	
	}





	public Part MontaRecipe(int id,int[] codigodaspecasusadas) {
		Iterator<Parts> iv=vecParts.iterator();
		int count=0;
		while(iv.hasNext()) {
			if(iv.next().getCodigoDestaPeca()==id) {
				vecParts.get(count).Monta(id, codigodaspecasusadas);
				return vecParts.get(count); //Encontrou e devolve a classe Part montada dentro do vector
				
			}
			count++;
				
		}
		
		
		return null;
	}
	



	
}
