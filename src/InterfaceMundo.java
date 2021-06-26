import java.util.ArrayList;
import java.rmi.*;
public interface InterfaceMundo extends Remote {

	
	ArrayList<String[]> getNomelistaDeServidoresConhecidos() throws RemoteException;
	void adicionaPartServer(String Nome, String Funcao) throws RemoteException;

	String ProcuraServer(String funcao) throws RemoteException;
	
	Part geraPart(int id) throws RemoteException ;
	Bloco geraBloco(int id) throws RemoteException ;
	Item geraItem(int id) throws RemoteException ;
	int adicionaItemNoServer(String Nome) throws RemoteException ;
	int getidItem(String nome) throws RemoteException ;
	String getStringItem(int id) throws RemoteException ;
	int getidMaterial(String nome) throws RemoteException ;
	String getStringMaterial(int id) throws RemoteException ;
	Material getMaterialbyString(String nome) throws RemoteException ;
	int adicionaMaterialNoServer(String nome,int Headdurabilidade,Encantamento  Headenchant1,Encantamento  Headenchant2,int Partsdurabilidade,Encantamento  Partenchant1,Encantamento  Partenchant2,int handleDurabilidade,float durabilityModifier) throws RemoteException ;
	void removeServer(String nome) throws RemoteException ;
	String listaServers() throws RemoteException ;
	String PrintaMateriais()  throws RemoteException ;
	String listaItens()  throws RemoteException ;

}