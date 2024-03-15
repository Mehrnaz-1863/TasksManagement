package com.example.tasksmanagement.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tasksmanagement.databinding.RecyclerItemBinding
import com.example.tasksmanagement.db.model.TaskEntity
import com.example.tasksmanagement.mvp.ext.OnBindData

class RecyclerTaskAdapter(
    private val tasks: ArrayList<TaskEntity>,
    private val onBindData: OnBindData
) : RecyclerView.Adapter<RecyclerTaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(
        private val binding: RecyclerItemBinding
    ) : ViewHolder(binding.root) {

        fun setData(data: TaskEntity) {

            binding.txtTitle.text = data.title
            binding.checkBox.isChecked = data.state
            binding.checkBox.setOnClickListener {
                if (data.state)
                    onBindData.editData(TaskEntity(data.id, data.title, false))
                else
                    onBindData.editData(TaskEntity(data.id, data.title, true))
            }
            binding.imgDelete.setOnClickListener {
                onBindData.deleteData(data)
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TaskViewHolder(
            RecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun getItemCount() = tasks.size


    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.setData(tasks[position])

    }
    fun dataUpdate(newList: ArrayList<TaskEntity>){

        val diffCallback = RecyclerDiffUtils(tasks,newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        tasks.clear()
        tasks.addAll(newList)
        diffResult.dispatchUpdatesTo(this)

    }
}