package com.route.task_e_ramo.acivity.fargment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.route.task_e_ramo.acivity.fargment.adapter.BrokerAdapter
import com.route.task_e_ramo.acivity.fargment.view_model.DetailsFragmentViewModel
import com.route.task_e_ramo.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    val viewModel : DetailsFragmentViewModel by viewModels<DetailsFragmentViewModel>()
    val projectItemsAdapter = BrokerAdapter()
    private lateinit var binding : FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getBrokerDetails("3")
        bindViews()
    }
    private fun bindViews(){
        binding.brokersRv.adapter=projectItemsAdapter
        lifecycleScope.launch {
            viewModel.projectItemList.collect{
                projectItemsAdapter.bindList(it)
            }
        }
        //binding.companyName.text = viewModel.name.value
        lifecycleScope.launch {
            viewModel.name.collect{
                binding.companyName.text=it
            }
        }
        lifecycleScope.launch {
            viewModel.description.collect{
                binding.companyDetails.text=it
            }
        }
        lifecycleScope.launch {
            viewModel.logo.collect{
                Glide.with(requireContext())
                    .load(it)
                    .into(binding.insideImage)
            }
        }
        //if response not success
        viewModel.viewMessage.observe(viewLifecycleOwner){
            showDialog(it.title,it.message)
        }
    }
    private fun showDialog(
        title: String? = null,
        message: String? = null,
        posBtnTitle: String? = null,
        onPosBtnClick: (() -> Unit)? = null,
        onNegBtnClick: (() -> Unit)? = null,
        negBtnTitle: String? = null,


        ) {
        val myDialog = AlertDialog.Builder(requireContext())
        myDialog.setTitle(title)
        myDialog.setMessage(message)
        posBtnTitle.let {
            myDialog.setPositiveButton(posBtnTitle,
                object : DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        dialog?.dismiss()
                        onPosBtnClick?.invoke()
                    }

                })
        }
        negBtnTitle.let {
            myDialog.setNegativeButton(negBtnTitle
            ) { dialog, which ->
                dialog?.dismiss()
                onNegBtnClick?.invoke()
            }
        }

        myDialog.create().show()

    }
}