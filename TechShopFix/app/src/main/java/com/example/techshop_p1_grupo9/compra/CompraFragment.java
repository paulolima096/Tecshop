package com.example.techshop_p1_grupo9.compra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.techshop_p1_grupo9.CarrinhoManager;
import com.example.techshop_p1_grupo9.R;
import com.example.techshop_p1_grupo9.carrinho.CarrinhoAdapter;

public class CompraFragment extends Fragment {

    public CompraFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compra, container, false);

        RecyclerView recycler = view.findViewById(R.id.recyclerCompra);
        TextView txtTotal = view.findViewById(R.id.txtTotalCompra);
        EditText etNome = view.findViewById(R.id.etNome);
        EditText etCep = view.findViewById(R.id.etCep);
        EditText etBairro = view.findViewById(R.id.etBairro);
        EditText etRua = view.findViewById(R.id.etRua);
        Button btnFinalizar = view.findViewById(R.id.btnFinalizarCompra);

        // Exibe os itens (somente leitura, sem botão remover)
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new CarrinhoAdapter(
                CarrinhoManager.getInstance().getItens(),
                posicao -> {} // sem remoção nessa tela
        ));

        txtTotal.setText(String.format("Total: R$ %.2f",
                CarrinhoManager.getInstance().getTotal()));

        btnFinalizar.setOnClickListener(v -> {
            String nome = etNome.getText().toString().trim();
            String cep = etCep.getText().toString().trim();
            String bairro = etBairro.getText().toString().trim();
            String rua = etRua.getText().toString().trim();

            if (nome.isEmpty() || cep.isEmpty() || bairro.isEmpty() || rua.isEmpty()) {
                Toast.makeText(getContext(), "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Passa dados para a tela de confirmação via Bundle
            Bundle args = new Bundle();
            args.putString("nome", nome);
            args.putString("endereco", rua + ", " + bairro + " - CEP " + cep);
            args.putDouble("total", CarrinhoManager.getInstance().getTotal());

            CarrinhoManager.getInstance().limpar();

            Navigation.findNavController(v)
                    .navigate(R.id.action_compra_to_pedidoFinalizado, args);
        });

        return view;
    }
}