package com.example.messagemanager.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.messagemanager.R
import com.example.messagemanager.data.MessageDataItem
import com.example.messagemanager.databinding.ActivityMainBinding.bind
import com.example.messagemanager.databinding.ItemMessageBinding

class MessageAdapter(private val onItemClicked: (position: Int) -> Unit) : ListAdapter<MessageDataItem, MessageAdapter.MessageViewHolder>(ContactsComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder.create(parent, onItemClicked)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class MessageViewHolder(
        item: View,
        private val onItemClicked: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(item) {
        private val binding = ItemMessageBinding.bind(item)

        fun bind(message: MessageDataItem) = with (binding) {
            root.setOnClickListener{
                onItemClicked.invoke(adapterPosition)
            }
            itemId.text = message.id.toString()
            itemTitle.text = message.title
        }

        companion object {
            fun create(parent: ViewGroup, onItemClicked: (position: Int) -> Unit): MessageViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_message, parent, false)
                return MessageViewHolder(view, onItemClicked)
            }
        }
    }

    class ContactsComparator : DiffUtil.ItemCallback<MessageDataItem>() {
        override fun areItemsTheSame(oldItem: MessageDataItem, newItem: MessageDataItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MessageDataItem, newItem: MessageDataItem): Boolean {
            return oldItem.title == newItem.title
        }
    }
}