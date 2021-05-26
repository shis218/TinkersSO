
public class Mundo {
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
private int ipMundoAtual;
private int portaMundoAtual;
private String[] nomelistaDeServidoresConhecidos; //Esses servidores podem ser part builders, part repositories, maquinas
private int[] iplistaDeServidoresConhecidos;
private int[] portalistaDeServidoresConhecidos;
public int getIpMundoAtual() {
	return ipMundoAtual;
}
public int getPortaMundoAtual() {
	return portaMundoAtual;
}
public String[] getNomelistaDeServidoresConhecidos() {
	return nomelistaDeServidoresConhecidos;
}
public int[] getIplistaDeServidoresConhecidos() {
	return iplistaDeServidoresConhecidos;
}
public int[] getPortalistaDeServidoresConhecidos() {
	return portalistaDeServidoresConhecidos;
}



	
}
