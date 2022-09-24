package cbassdagreat.github.centro_formacion_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cbassdagreat.github.centro_formacion_app.R
import cbassdagreat.github.centro_formacion_app.databinding.ItemLayoutBinding
import cbassdagreat.github.centro_formacion_app.model.CursosItem
import cbassdagreat.github.centro_formacion_app.model.ListaCursos
import com.squareup.picasso.Picasso

class CursoItemAdapter :RecyclerView.Adapter<CursoItemAdapter.CustomViewHolder> (){
    class CustomViewHolder(itemView: View, var listener: MiOnClickListener):RecyclerView.ViewHolder(itemView)
    {
        private val binding=ItemLayoutBinding.bind(itemView)

        fun bindData(cursosItem: CursosItem)
        {
            with(binding)
            {
                Picasso.get().load(cursosItem.image).resize(130,130).into(ivListaImg)
                tvListaNom.text=cursosItem.title
                tvListaTime.text=cursosItem.weeks.toString()
                itemView.setOnClickListener{
                    listener.onClickListener(cursosItem)
                }
            }
        }
    }

    private var lista:List<CursosItem> = ListaCursos()
    lateinit var listener: MiOnClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return CustomViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
            }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun updateData(lista:List<CursosItem>)
    {
        this.lista=lista
        notifyDataSetChanged()
    }

    interface MiOnClickListener{
        fun onClickListener(cursosItem: CursosItem)
    }

    fun setMiOnClickListener(listener:MiOnClickListener)
    {
        this.listener=listener
    }
}