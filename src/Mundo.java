
public class Mundo {
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
