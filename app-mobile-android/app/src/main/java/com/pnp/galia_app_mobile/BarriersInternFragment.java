package com.pnp.galia_app_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class BarriersInternFragment extends Fragment {
    private RecyclerView recyclerView;

    public BarriersInternFragment() {
        // Required empty public constructor
    }

    public static BarriersInternFragment newInstance(Bundle arguments) {
        BarriersInternFragment fragment = new BarriersInternFragment();
        if (arguments != null) {
            fragment.setArguments(arguments);
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_barriers_intern, container, false);
        recyclerView = myView.findViewById(R.id.barrier_intern_recycler);

        Barrier[] barrierList = new Barrier[] {new Barrier("1", "Ausencia de redes de apoyo", "B02", "Maria Gutierrez L", "Barrera numero uno", "Sociocultural", "Media", "Interna"), new Barrier("2", "Religión", "B07", "Lucía Brenes J", "Barrera numero dos", "Personal", "Alta", "Interna"), new Barrier("3", "Desestimación del caso", "B23", "Yolanda Rojas", "Barrera numero tres", "Serv.Salud", "Alta", "Externa"), new Barrier("4", "Variaciones del personal médico", "B27", "Miriam Ureña P", "Barrera numero cuatro", "Serv.Salud", "Baja", "Externa")};
        getVisibleView(filterBarriers(barrierList));
        return myView;
    }

    private void getVisibleView(Barrier[] listBarriers) {
        Barrier[] myFilterListBarriers = filterBarriers(listBarriers);
        if (myFilterListBarriers.length > 0) {
            BarrierAdapter adapter = new BarrierAdapter(myFilterListBarriers);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        } else {
            recyclerView.setVisibility(View.INVISIBLE);
        }
    }

    private Barrier[] filterBarriers(Barrier[] listBarriers) {
        int numElements = listBarriers.length;
        int counter = 0;
        int counter2 = 0;
        String typeBarrier;
        int numBarriers = 0;
        Barrier myBarrier;

        //Calcular numero de elementos de barreras externas
        while (counter < numElements) {
            typeBarrier = listBarriers[counter].getType();
            if (Objects.equals(typeBarrier, "Interna")) {
                numBarriers = numBarriers + 1;
            }
            counter = counter + 1;
        }

        Barrier[] myFilterList = new Barrier[numBarriers];
        counter = 0;
        while (counter < numElements) {
            myBarrier = listBarriers[counter];
            typeBarrier = listBarriers[counter].getType();

            if (Objects.equals(typeBarrier, "Interna")) {
                myFilterList[counter2] = new Barrier(myBarrier.getId(),
                        myBarrier.getName(), myBarrier.getCode(),
                        myBarrier.getPatient(), myBarrier.getDescription(),
                        myBarrier.getClassification(), myBarrier.getPriority(),
                        myBarrier.getType());
                counter2 = counter2 + 1;
            }
            counter = counter + 1;
        }
        return myFilterList;
    }
}