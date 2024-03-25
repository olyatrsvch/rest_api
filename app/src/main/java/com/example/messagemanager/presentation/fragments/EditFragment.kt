package com.example.messagemanager.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.messagemanager.R
import com.example.messagemanager.data.MessageDataItem
import com.example.messagemanager.databinding.FragmentEditBinding
import com.example.messagemanager.domain.MessageRepositoryImpl
import com.example.messagemanager.presentation.adapters.MessageAdapter
import com.example.messagemanager.presentation.viewmodels.MessageViewModel
import com.example.messagemanager.presentation.viewmodels.MessageViewModelFactory

class EditFragment(val position: Int) : DialogFragment() {

    private lateinit var binding: FragmentEditBinding
    private val viewModel: MessageViewModel by activityViewModels {
        MessageViewModelFactory(MessageRepositoryImpl())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with (binding) {

            val text = viewModel.messageList.value?.get(position)?.title
            etTitle.setText(text)

            btnApply.setOnClickListener {

                val messages = viewModel.messageList.value as MutableList
                messages[position].title = etTitle.text.toString()
                viewModel.postData(messages)
                dismiss()
            }

            btnCancel.setOnClickListener {
                dismiss()
            }

        }
    }
}