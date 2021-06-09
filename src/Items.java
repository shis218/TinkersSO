
public class Items {
//Items são partes especiais que não podem ser colocados no mundo, no entanto elas podem ser geradas por resultados de ações em maquinas
//Items podem ser encantados em maquinas que possuem suas propias listas de encantamento e não necessitam de serem unificadas com o mundo
	
	private boolean isFerramenta; //Se é um item basico ou ferramenta
	private int ingameID; //Itens basicos possuem ingameID, ferramentas complexas não possuem 
	
	private Materiais[] materialTraits; //De quais material é feito o item
	private Encantamento[] enchants; //Lista de encantamentos, inicialmente com os vindo de materiais e podem ter extras adicionados por maquinas

	private int codigoDesteitem; //Codigo unico deste item
	private String nome; //String do nome deste item, é possivel alterar seu nome após criada por meio do uso de maquinas
	

	private boolean existe;  //Todos itens existem
	private Part[] parteUsadas; //Guarda informações das peças usads para criação da ferramenta, incluindo os ids unicos. Isso pode ser util numa maquina de desmontar.

	

}
