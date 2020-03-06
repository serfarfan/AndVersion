package com.sandoval.rxapiexample.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.bela.andversion.R
import com.bela.andversion.model.data.Android
import com.bela.andversion.view.adapter.DataAdapter
import com.bela.andversion.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private val listDataAdapter = DataAdapter(arrayListOf())

    private val androidListObserver = Observer<List<Android>> { list ->
        list?.let {
            androidlList.visibility = View.VISIBLE
            listDataAdapter.updateAndroidList(it)
        }
    }

    private val errorObserver = Observer<Boolean> { error ->
        listError.visibility = if (error) View.VISIBLE else View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.androidVersions.observe(viewLifecycleOwner, androidListObserver)
        viewModel.loadError.observe(viewLifecycleOwner, errorObserver)
        viewModel.refresh()

        androidlList.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = listDataAdapter
        }

        refreshLayout.setOnRefreshListener {
            androidlList.visibility = View.GONE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }
    }

}
