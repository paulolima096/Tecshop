package com.example.techshop_p1_grupo9.carrinho;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.techshop_p1_grupo9.CarrinhoManager;
import com.example.techshop_p1_grupo9.R;

public class CarrinhoFragment extends Fragment {

    private CarrinhoAdapter adapter;
    private TextView txtTotal;

    public CarrinhoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carrinho, container, false);

        RecyclerView recycler = view.findViewById(R.id.recyclerCarrinho);
        txtTotal = view.findViewById(R.id.txtTotalCarrinho);
        Button btnContinuar = view.findViewById(R.id.btnContinuar);

        view.findViewById(R.id.btnVoltar).setOnClickListener(v ->
                Navigation.findNavController(v).popBackStack()
        );

        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new CarrinhoAdapter(
                CarrinhoManager.getInstance().getItens(),
                posicao -> {
                    CarrinhoManager.getInstance().remover(posicao);
                    adapter.notifyItemRemoved(posicao);
                    adapter.notifyItemRangeChanged(posicao, adapter.getItemCount());
                    atualizarTotal();
                }
        );

        recycler.setAdapter(adapter);
        atualizarTotal();

        btnContinuar.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_carrinho_to_compra)
        );

        return view;
    }

    private void atualizarTotal() {
        txtTotal.setText(String.format("Total: R$ %.2f",
                CarrinhoManager.getInstance().getTotal()));
    }
}