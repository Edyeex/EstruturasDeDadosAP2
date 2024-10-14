import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

	Pilha pilhaCancelados = new Pilha();
	Fila filaPendentes = new Fila();
	ListaDuplamenteLigada biblioteca = new ListaDuplamenteLigada();

	Scanner scanner = new Scanner(System.in);
	int opcao;

	do {
	  System.out.println("------ MENU ------");
	  System.out.println("1 - Adicionar Novo Pedido");
	  System.out.println("2 - Atender Pedido");
	  System.out.println("3 - Cancelar Pedido");
	  System.out.println("4 - Restaurar Pedido Cancelado");
	  System.out.println("5 - Imprimir Pedidos Pendentes");
	  System.out.println("6 - Imprimir Pedidos Cancelados");
	  System.out.println("7 - Adicionar Novo Livro na Biblioteca (Início)");
	  System.out.println("8 - Adicionar Novo Livro na Biblioteca (Fim)");
	  System.out.println("9 - Remover Primeiro Livro");
	  System.out.println("10 - Remover Último Livro");
	  System.out.println("11 - Buscar Livro por ID");
	  System.out.println("12 - Imprimir Livros na Ordem Original");
	  System.out.println("13 - Imprimir Livros na Ordem Reversa");
	  System.out.println("0 - Sair");
	  System.out.print("Escolha uma opção: ");
	  opcao = scanner.nextInt();
	  scanner.nextLine(); // Consumir a quebra de linha

	  switch (opcao) {
		case 1:

		  System.out.print("Digite o ID do pedido: ");
		  int idPedido = scanner.nextInt();
		  scanner.nextLine();
		  System.out.print("Digite a descrição do pedido: ");
		  String descricaoPedido = scanner.nextLine();
		  filaPendentes.adicionarNovoPedido(idPedido, descricaoPedido);
		  System.out.println("Pedido adicionado à fila de pendentes.");

		  break;

		case 2:

		  Pedido pedidoAtendido = filaPendentes.removerPedidoMaisAntigo();
		  if (pedidoAtendido != null) {
			System.out.println("Pedido atendido: ID " + pedidoAtendido.id + ", Descrição: " + pedidoAtendido.descricao);
		  } else {
			System.out.println("Nenhum pedido pendente.");
		  }

		  break;

		case 3:

		  Pedido pedidoCancelado = filaPendentes.removerPedidoMaisAntigo();
		  if (pedidoCancelado != null) {
			pilhaCancelados.adicionar(pedidoCancelado.id, pedidoCancelado.descricao);
			System.out.println("Pedido cancelado: ID " + pedidoCancelado.id + ", Descrição: " + pedidoCancelado.descricao);
		  } else {
			System.out.println("Nenhum pedido para cancelar.");
		  }

		  break;

		case 4:

		  Pedido pedidoRestaurado = pilhaCancelados.remover();
		  if (pedidoRestaurado != null) {
			filaPendentes.adicionarNovoPedido(pedidoRestaurado.id, pedidoRestaurado.descricao);
			System.out.println("Pedido restaurado: ID " + pedidoRestaurado.id + ", Descrição: " + pedidoRestaurado.descricao);
		  } else {
			System.out.println("Nenhum pedido cancelado para restaurar.");
		  }

		  break;

		case 5:

		  System.out.println("Pedidos pendentes:");
		  filaPendentes.mostrarPedidosPendentes();

		  break;

		case 6:

		  System.out.println("Pedidos cancelados:");
		  pilhaCancelados.mostrarPedidosCancelados();

		  break;

		case 7:

		  System.out.print("Digite o ID do livro: ");
		  int idLivroInicio = scanner.nextInt();
		  scanner.nextLine();
		  System.out.print("Digite o título do livro: ");
		  String tituloLivroInicio = scanner.nextLine();
		  System.out.print("Digite o autor do livro: ");
		  String autorLivroInicio = scanner.nextLine();
		  biblioteca.adicionarNoInicio(idLivroInicio, tituloLivroInicio, autorLivroInicio);
		  System.out.println("Livro adicionado no início da lista.");

		  break;

		case 8:

		  System.out.print("Digite o ID do livro: ");
		  int idLivroFim = scanner.nextInt();
		  scanner.nextLine();
		  System.out.print("Digite o título do livro: ");
		  String tituloLivroFim = scanner.nextLine();
		  System.out.print("Digite o autor do livro: ");
		  String autorLivroFim = scanner.nextLine();
		  biblioteca.adicionarNoFim(idLivroFim, tituloLivroFim, autorLivroFim);
		  System.out.println("Livro adicionado no fim da lista.");

		  break;

		case 9:

		  Livro livroRemovidoInicio = biblioteca.removerDoInicio();
		  if (livroRemovidoInicio != null) {
			System.out.println("Livro removido: ID " + livroRemovidoInicio.id + ", Título: " + livroRemovidoInicio.titulo);
		  } else {
			System.out.println("Nenhum livro para remover.");
		  }

		  break;

		case 10:

		  Livro livroRemovidoFim = biblioteca.removerDoFim();
		  if (livroRemovidoFim != null) {
			System.out.println("Livro removido: ID " + livroRemovidoFim.id + ", Título: " + livroRemovidoFim.titulo);
		  } else {
			System.out.println("Nenhum livro para remover.");
		  }

		  break;

		case 11:

		  System.out.print("Digite o ID do livro para buscar: ");
		  int idLivroBusca = scanner.nextInt();
		  scanner.nextLine();
		  Livro livroEncontrado = biblioteca.buscarPorID(idLivroBusca);
		  if (livroEncontrado != null) {
			System.out.println("Livro encontrado: ID " + livroEncontrado.id + ", Título: " + livroEncontrado.titulo + ", Autor: " + livroEncontrado.autor);
		  } else {
			System.out.println("Livro não encontrado.");
		  }

		  break;

		case 12:

		  System.out.println("Livros na ordem original:");
		  biblioteca.imprimirNaOrdemOriginal();

		  break;

		case 13:

		  System.out.println("Livros na ordem reversa:");
		  biblioteca.imprimirNaOrdemReversa();

		  break;

		case 0:

		  System.out.println("Saindo...");

		  break;

		default:

		  System.out.println("Opção inválida.");

		  break;
	  }

	} while (opcao != 0);

	scanner.close();
  }
}
