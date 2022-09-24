package cbassdagreat.github.centro_formacion_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cbassdagreat.github.centro_formacion_app.databinding.ActivityMainBinding
import cbassdagreat.github.centro_formacion_app.viewmodel.CursoVM

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<CursoVM>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.callCursoItem()
    }
}