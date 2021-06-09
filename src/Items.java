
public class Items {
//Items s�o partes especiais que n�o podem ser colocados no mundo, no entanto elas podem ser geradas por resultados de a��es em maquinas
//Items podem ser encantados em maquinas que possuem suas propias listas de encantamento e n�o necessitam de serem unificadas com o mundo
	
	private boolean isFerramenta; //Se � um item basico ou ferramenta
	private int ingameID; //Itens basicos possuem ingameID, ferramentas complexas n�o possuem 
	
	private Materiais[] materialTraits; //De quais material � feito o item
	private Encantamento[] enchants; //Lista de encantamentos, inicialmente com os vindo de materiais e podem ter extras adicionados por maquinas

	private int codigoDesteitem; //Codigo unico deste item
	private String nome; //String do nome deste item, � possivel alterar seu nome ap�s criada por meio do uso de maquinas
	

	private boolean existe;  //Todos itens existem
	private Part[] parteUsadas; //Guarda informa��es das pe�as usads para cria��o da ferramenta, incluindo os ids unicos. Isso pode ser util numa maquina de desmontar.

	

}
