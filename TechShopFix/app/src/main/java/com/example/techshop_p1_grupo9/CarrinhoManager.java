package com.example.techshop_p1_grupo9;

import com.example.techshop_p1_grupo9.home.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton que mantém a lista de produtos no carrinho
 * durante toda a sessão do app.
 */
public class CarrinhoManager {

    private static CarrinhoManager instancia;
    private final List<Produto> itens = new ArrayList<>();

    private CarrinhoManager() {}

    public static CarrinhoManager getInstance() {
        if (instancia == null) {
            instancia = new CarrinhoManager();
        }
        return instancia;
    }

    public void adicionar(Produto produto) {
        itens.add(produto);
    }

    public void remover(int posicao) {
        if (posicao >= 0 && posicao < itens.size()) {
            itens.remove(posicao);
        }
    }

    public List<Produto> getItens() {
        return itens;
    }

    public double getTotal() {
        double total = 0;
        for (Produto p : itens) {
            total += p.getPreco();
        }
        return total;
    }

    public void limpar() {
        itens.clear();
    }
}