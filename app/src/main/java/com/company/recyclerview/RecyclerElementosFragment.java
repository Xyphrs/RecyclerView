package com.company.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.company.recyclerview.databinding.FragmentRecyclerElementosBinding;
import com.company.recyclerview.databinding.ViewholderElementoBinding;

import java.util.List;


public class RecyclerElementosFragment extends Fragment {

    private FragmentRecyclerElementosBinding binding;
    private ElementosViewModel elementosViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRecyclerElementosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        elementosViewModel = new ViewModelProvider(requireActivity()).get(ElementosViewModel.class);
        navController = Navigation.findNavController(view);

        ElementosAdapter elementosAdapter = new ElementosAdapter();
        binding.recycler.setAdapter(elementosAdapter);

        binding.recycler.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        elementosViewModel.obtenerListaElementos().observe(getViewLifecycleOwner(), elementosAdapter::establishList);
    }
        class ElementosAdapter extends RecyclerView.Adapter<ElementoViewHolder> {
            List<Elemento> elementoList;

            @NonNull
            @Override
            public ElementoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new ElementoViewHolder(ViewholderElementoBinding.inflate(getLayoutInflater(), parent, false));
            }

            @Override
            public void onBindViewHolder(@NonNull ElementoViewHolder holder, int position) {
                Elemento elemento = elementoList.get(position);

                holder.binding.nombre.setText(elemento.nombre);

                holder.itemView.setOnClickListener(v -> {
                    elementosViewModel.establecerElementoSeleccionado(elemento);
                    navController.navigate(R.id.action_recyclerElementosFragment_to_mostrarElementoFragment);
                });
            }

            @Override
            public int getItemCount() {
                return elementoList !=null ? elementoList.size() : 0;
            }

            public void establishList(List<Elemento> elementos){
                this.elementoList = elementos;
                notifyDataSetChanged();
            }
        }

    static class ElementoViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderElementoBinding binding;

        public ElementoViewHolder(ViewholderElementoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}