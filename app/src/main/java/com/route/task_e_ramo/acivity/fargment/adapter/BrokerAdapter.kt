package com.route.task_e_ramo.acivity.fargment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.route.task_e_ramo.api.model.ProjectsItem
import com.route.task_e_ramo.databinding.BrokerItemTwoBinding

class BrokerAdapter(private var projectItemList : List<ProjectsItem?>?=null) : Adapter<BrokerAdapter.BrokerViewHolder>() {

    fun bindList(myList : List<ProjectsItem?>?){
        this.projectItemList=myList
        notifyDataSetChanged()
    }
    class BrokerViewHolder(val binding: BrokerItemTwoBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun bind(projectItem:ProjectsItem){
                binding.titleProjectItem.text = projectItem.title
                binding.descriptionProjectItem.text = projectItem.description
                binding.addressTxt.text = projectItem.city
                Glide.with(itemView)
                    .load(projectItem.image)
                    .into(binding.projectItemImage)
            }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrokerViewHolder {
        return BrokerViewHolder(BrokerItemTwoBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: BrokerViewHolder, position: Int) {
        val projectItem = projectItemList?.get(position)
        holder.bind(projectItem!!)
    }

    override fun getItemCount(): Int {
        return projectItemList?.size ?: 0
    }
}