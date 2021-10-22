package com.mhl.medit.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.mhl.medit.R
import com.mhl.medit.recadapters.FeelRecycler
import com.mhl.medit.recadapters.MyFeel
import com.mhl.medit.recadapters.MyState
import com.mhl.medit.recadapters.StateRecycler

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val feelRecycler : RecyclerView = root.findViewById(R.id.recyclerView)
        feelRecycler.adapter = FeelRecycler(requireContext(), MyFeel().list)
        val stateRecycler : RecyclerView = root.findViewById(R.id.recyclerView2)
        stateRecycler.adapter = StateRecycler(requireContext(), MyState().state_list)
        return root
    }
}