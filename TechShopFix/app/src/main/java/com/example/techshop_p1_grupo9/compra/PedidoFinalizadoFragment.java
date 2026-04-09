package com.example.techshop_p1_grupo9.compra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.techshop_p1_grupo9.R;

public class PedidoFinalizadoFragment extends Fragment {

    public PedidoFinalizadoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pedido_finalizado, container, false);

        TextView txtNome = view.findViewById(R.id.txtResumoNome);
        TextView txtEndereco = view.findViewById(R.id.txtResumoEndereco);
        TextView txtTotal = view.findViewById(R.id.txtResumoTotal);
        Button btnVoltar = view.findViewById(R.id.btnVoltarInicio);

        Bundle args = getArguments();
        if (args != null) {
            txtNome.setText("Nome: " + args.getString("nome", "—"));
            txtEndereco.setText("Endereço: " + args.getString("endereco", "—"));
            txtTotal.setText(String.format("Total: R$ %.2f", args.getDouble("total", 0)));
        }

        btnVoltar.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_pedidoFinalizado_to_home)
        );

        return view;
    }
}