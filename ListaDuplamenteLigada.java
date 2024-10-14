
  class ListaDuplamenteLigada {
	private Livro inicio, fim;

	public ListaDuplamenteLigada() {

	  inicio = fim = null;

	}

	// Adicionar novo livro no início da lista
	public void adicionarNoInicio(int id, String titulo, String autor) {

	  Livro novoLivro = new Livro(id, titulo, autor);
	  if (inicio == null) {
		inicio = fim = novoLivro;
	  } else {
		novoLivro.next = inicio;
		inicio.prev = novoLivro;
		inicio = novoLivro;
	  }

	}

	// Adicionar novo livro no fim da lista
	public void adicionarNoFim(int id, String titulo, String autor) {

	  Livro novoLivro = new Livro(id, titulo, autor);
	  if (fim == null) {
		inicio = fim = novoLivro;
	  } else {
		fim.next = novoLivro;
		novoLivro.prev = fim;
		fim = novoLivro;
	  }

	}

	// Remover o primeiro livro da lista
	public Livro removerDoInicio() {

	  if (inicio == null) return null;
	  Livro livroRemovido = inicio;
	  inicio = inicio.next;
	  if (inicio != null) inicio.prev = null;
	  else fim = null;
	  return livroRemovido;

	}

	// Remover o último livro da lista
	public Livro removerDoFim() {

	  if (fim == null) return null;
	  Livro livroRemovido = fim;
	  fim = fim.prev;
	  if (fim != null) fim.next = null;
	  else inicio = null;
	  return livroRemovido;

	}

	// Pesquisar livro por ID
	public Livro buscarPorID(int id) {

	  Livro atual = inicio;
	  while (atual != null) {
		if (atual.id == id) return atual;
		atual = atual.next;
	  }
	  return null;

	}

	// Imprimir livros na ordem original (primeiro ao último)
	public void imprimirNaOrdemOriginal() {

	  Livro atual = inicio;
	  while (atual != null) {
		System.out.println("ID: " + atual.id + ", Título: " + atual.titulo + ", Autor: " + atual.autor);
		atual = atual.next;
	  }

	}

	// Imprimir livros na ordem inversa (último ao primeiro)
	public void imprimirNaOrdemReversa() {

	  Livro atual = fim;
	  while (atual != null) {
		System.out.println("ID: " + atual.id + ", Título: " + atual.titulo + ", Autor: " + atual.autor);
		atual = atual.prev;

	  }
	}
  }


