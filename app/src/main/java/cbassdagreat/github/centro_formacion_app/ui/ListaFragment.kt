package cbassdagreat.github.centro_formacion_app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import cbassdagreat.github.centro_formacion_app.R
import cbassdagreat.github.centro_formacion_app.adapter.CursoItemAdapter
import cbassdagreat.github.centro_formacion_app.databinding.FragmentListaBinding
import cbassdagreat.github.centro_formacion_app.model.CursosItem
import cbassdagreat.github.centro_formacion_app.viewmodel.CursoVM

class ListaFragment : Fragment() {
    lateinit var binding: FragmentListaBinding
    private val viewModel by activityViewModels<CursoVM>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentListaBinding.inflate(layoutInflater)

        val adapter=CursoItemAdapter()
        adapter.setMiOnClickListener(object :CursoItemAdapter.MiOnClickListener{
            override fun onClickListener(cursosItem: CursosItem) {
                viewModel.getCursoDetalle(cursosItem.id)
                viewModel.id.value=cursosItem.id
                Navigation.findNavController(requireView()).navigate(R.id.action_listaFragment_to_detalleFragment)
            }
        })
        val layoutManager=LinearLayoutManager(requireContext())

        with(binding)
        {
            rvLista.adapter=adapter
            rvLista.layoutManager=layoutManager
        }

        viewModel.listaCursos.observe(viewLifecycleOwner, Observer{
            adapter.updateData(it)
        })

        return binding.root
    }


}