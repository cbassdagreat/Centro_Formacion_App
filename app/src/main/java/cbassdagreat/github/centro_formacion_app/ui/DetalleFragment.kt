package cbassdagreat.github.centro_formacion_app.ui

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cbassdagreat.github.centro_formacion_app.R
import cbassdagreat.github.centro_formacion_app.databinding.FragmentDetalleBinding
import cbassdagreat.github.centro_formacion_app.viewmodel.CursoVM
import com.squareup.picasso.Picasso

class DetalleFragment : Fragment() {

    lateinit var binding: FragmentDetalleBinding
    private val viewModel by activityViewModels<CursoVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetalleBinding.inflate(layoutInflater)

        with(binding)
        {
            btnDetMail.setOnClickListener {
                val nombre=tvDetNom.text
                val intent = Intent(Intent.ACTION_SENDTO)
            }
        }

        viewModel.listaCursoDetalle.observe(viewLifecycleOwner, Observer{
            viewModel.buscarCurso()
        })

        viewModel.curso.observe(viewLifecycleOwner,Observer{
            if(it!=null) {
                with(binding)
                {
                    Picasso.get().load(it.image).into(ivDetImg)
                    tvDetNom.text = it.title
                    tvDetDesc.text = it.description
                    tvDetHab.text = it.minimumSkill
                    tvDetPrecio.text = it.tuition
                    tvDetTiempo.text = it.weeks.toString()

                }

            }
        })

        return binding.root
    }

}