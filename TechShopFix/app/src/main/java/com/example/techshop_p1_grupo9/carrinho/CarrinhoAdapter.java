package com.example.techshop_p1_grupo9.carrinho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.techshop_p1_grupo9.R;
import com.example.techshop_p1_grupo9.home.Produto;

import java.util.List;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder> {

    public interface OnRemoverClickListener {
        void onRemover(int posicao);
    }

    private final List<Produto> itens;
    private final OnRemoverClickListener listener;

    public CarrinhoAdapter(List<Produto> itens, OnRemoverClickListener listener) {
        this.itens = itens;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CarrinhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_carrinho, parent, false);
        return new CarrinhoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarrinhoViewHolder holder, int position) {
        Produto produto = itens.get(position);

        holder.txtNome.setText(produto.getNome());
        holder.txtPreco.setText(String.format("R$ %.2f", produto.getPreco()));
        holder.imgProduto.setImageResource(produto.getImagemRes());

        // Calcula parcelas exemplo: 10x ou 12x dependendo do preço
        int parcelas = produto.getPreco() > 500 ? 12 : 10;
        double valorParcela = produto.getPreco() / parcelas;
        holder.txtParcelas.setText(String.format("%dx de R$ %.2f sem juros", parcelas, valorParcela));

        holder.btnRemover.setOnClickListener(v -> listener.onRemover(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    public static class CarrinhoViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduto;
        TextView btnRemover;
        TextView txtNome, txtPreco, txtParcelas;

        public CarrinhoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduto = itemView.findViewById(R.id.imgProdutoCarrinho);
            txtNome = itemView.findViewById(R.id.txtNomeCarrinho);
            txtPreco = itemView.findViewById(R.id.txtPrecoCarrinho);
            txtParcelas = itemView.findViewById(R.id.txtParcelasCarrinho);
            btnRemover = itemView.findViewById(R.id.btnRemoverItem);
        }
    }
}