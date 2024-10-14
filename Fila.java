public class Fila {

  private Pedido frente, tras;

  public  Fila() {
	frente = tras = null;

  }

  public void adicionarNovoPedido(int id, String descricao) {

	Pedido novoPedido = new Pedido(id, descricao);
	if (tras != null) tras.next = novoPedido;
	tras = novoPedido;
	if (frente == null) frente = tras;

  }

  public Pedido removerPedidoMaisAntigo() {

	if (frente == null) return null;
	Pedido pedidoRemovido = frente;
	frente = frente.next;
	if (frente == null) tras = null;
	return pedidoRemovido;

  }

  public void mostrarPedidosPendentes() {

	Pedido atual = frente;
	while (atual != null) {
	  System.out.println("ID: " + atual.id + ", Descrição: " + atual.descricao);
	  atual = atual.next;

	}
  }
}
