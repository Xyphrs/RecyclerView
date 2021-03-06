package com.company.recyclerview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ElementosViewModel extends AndroidViewModel {

    ElementosRepositorio elementosRepositorio;

    MutableLiveData<List<Elemento>> listaElementos = new MutableLiveData<>();
    MutableLiveData<Elemento> elementoSeleccionado = new MutableLiveData<>();

    public ElementosViewModel(@NonNull Application application) {
        super(application);

        elementosRepositorio = new ElementosRepositorio();

        listaElementos.setValue(elementosRepositorio.elementos);
    }

    MutableLiveData<List<Elemento>> obtenerListaElementos(){
        return listaElementos;
    }

    void establecerElementoSeleccionado(Elemento elemento){
        elementoSeleccionado.setValue(elemento);
    }
}
