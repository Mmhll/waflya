package com.mhl.medit.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.mhl.medit.R
import com.mhl.medit.recadapters.FeelRecycler
import com.mhl.medit.recadapters.MyFeel
import com.mhl.medit.recadapters.MyState
import com.mhl.medit.recadapters.StateRecycler
import com.mhl.medit.retrofit.MyRetrofit
import com.mhl.medit.retrofit.feelings
import com.mhl.medit.retrofit.quotes
import com.mhl.medit.retrofit.retrofit_api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val quotes = MyRetrofit().getRetrofit()
        val api_ret = quotes.create(retrofit_api::class.java)
        val feelingsCall : Call<feelings> = api_ret.getFeelings()
        val quotes_call : Call<quotes> = api_ret.getQuotes()
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val feelRecycler : RecyclerView = root.findViewById(R.id.recyclerView)
        val stateRecycler : RecyclerView = root.findViewById(R.id.recyclerView2)
        quotes_call.enqueue(object : Callback<quotes>{
            override fun onResponse(call: Call<quotes>, response: Response<quotes>) {
                if (response.isSuccessful) {
                    stateRecycler.adapter =
                        response.body()?.let { StateRecycler(requireContext(), it) }
                }
            }

            override fun onFailure(call: Call<quotes>, t: Throwable) {
            }
        })
        feelingsCall.enqueue(object : Callback<feelings>{
            override fun onResponse(call: Call<feelings>, response: Response<feelings>) {
                if (response.isSuccessful) {
                    feelRecycler.adapter =
                        response.body()?.let { FeelRecycler(requireContext(), it) }
                }
            }

            override fun onFailure(call: Call<feelings>, t: Throwable) {
            }

        })
        return root
    }
}