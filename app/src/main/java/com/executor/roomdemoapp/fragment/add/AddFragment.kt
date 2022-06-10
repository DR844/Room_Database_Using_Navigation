package com.executor.roomdemoapp.fragment.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.executor.roomdemoapp.model.User
import com.executor.roomdemoapp.viewmodel.UserViewModel
import com.executor.roomdemoapp.R
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val fname = addFirstName_et.text.toString()
        val lname = addLastName_et.text.toString()
        val age = addAge_et.text

        if (inputCheck(fname, lname, age)) {
            val user = User(0, fname, lname, Integer.parseInt(age.toString()))
            mUserViewModel.addUsr(user)
            Toast.makeText(requireContext(), "Successfully Added", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all Fields", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun inputCheck(fname: String, lname: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(fname) && TextUtils.isEmpty(lname) && age.isEmpty())
    }

}