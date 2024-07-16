package com.route.task_e_ramo.acivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.route.task_e_ramo.acivity.fargment.DetailsFragment
import com.route.task_e_ramo.R
import com.route.task_e_ramo.acivity.fargment.view_model.DetailsFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

     var detailsFragment = DetailsFragment()
    val viewModel : DetailsFragmentViewModel by viewModels<DetailsFragmentViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val supportFragmentManager = supportFragmentManager
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container,detailsFragment).commit()
    }
}