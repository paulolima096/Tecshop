# TechShop – P1 Grupo 9

App Android de e-commerce de produtos de tecnologia. O usuário navega pelo catálogo, visualiza produtos com imagem e preço, adiciona itens ao carrinho e finaliza a compra.

- **Pacote:** com.example.techshop_p1_grupo9
- **Linguagem:** Java
- **SDK mínimo:** API 24 (Android 7.0)
- **SDK alvo:** API 36

---

## Estrutura do Projeto
---

## Activity

### MainActivity
Única Activity do projeto. Inicializa o layout com EdgeToEdge e hospeda o `NavHostFragment`, que gerencia a navegação entre os fragments.

---

## Fragments

### homeFragment
Tela principal do app. Exibe header com barra de pesquisa e ícone de carrinho, banners promocionais e lista de produtos via RecyclerView. Ao clicar em um produto, um `AlertDialog` oferece as opções de adicionar ao carrinho ou comprar agora.

### CarrinhoFragment
Tela do carrinho de compras. Estrutura criada, implementação pendente.

### CompraFragment
Tela de finalização de compra. Estrutura criada, implementação pendente.

---

## RecyclerView

### Produto.java
Modelo de dados com os atributos `nome` (String), `preco` (double) e `imagemRes` (int).

### ProdutoAdapter.java
Adapter que renderiza a lista de produtos. Implementa `OnProdutoClickListener` para capturar cliques nos itens.

---

## Navegação

Utiliza o Android Navigation Component com grafo definido em `nav_graph.xml`.

| Ação | Origem | Destino |
|------|--------|---------|
| action_home_to_carrinho | homeFragment | CarrinhoFragment |
| action_home_to_compra | homeFragment | CompraFragment |
| action_carrinho_to_compra | CarrinhoFragment | CompraFragment |

---

## Produtos Cadastrados

| Produto | Preço |
|---------|-------|
| Water Cooler | R$ 250,00 |
| Placa de Vídeo | R$ 1.700,00 |
| Fonte 650W | R$ 309,00 |
| Mouse Gamer | R$ 500,00 |
| Teclado Mecânico | R$ 350,00 |

---

## Dependências

| Biblioteca | Versão |
|------------|--------|
| appcompat | 1.7.1 |
| material | 1.13.0 |
| activity | 1.13.0 |
| constraintlayout | 2.2.1 |
| navigation-fragment-ktx | 2.9.7 |
| navigation-ui-ktx | 2.9.7 |

---

## Requisitos Obrigatórios

| Requisito | Status |
|-----------|--------|
| RecyclerView | Implementado em homeFragment com ProdutoAdapter |
| Activities |  MainActivity como host dos fragments |
| Fragments | homeFragment, CarrinhoFragment e CompraFragment |
| Comunicação por objetos |  Classe Produto criada, passagem via Bundle pendente |
| Layout ergonômico | Header fixo, scroll fluido e paleta de cores consistente |
