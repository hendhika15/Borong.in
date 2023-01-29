package com.kampus.borongin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kampus.borongin.data.Item
import com.kampus.borongin.data.ListItemAdapter

class HomeFragment : Fragment() {
    private lateinit var rvItem : RecyclerView
    private val list = ArrayList<Item>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvItem = view.findViewById(R.id.rv_item_view)
        rvItem.setHasFixedSize(true)

        list.addAll(listItems)
        showRecycleList()
    }


    private val listItems : ArrayList<Item>
        get() {
            val dataNumber = resources.getStringArray(R.array.data_number_item)
            val dataFoto = resources.obtainTypedArray(R.array.data_foto)
            val listItem = ArrayList<Item>()
            for (i in dataNumber.indices){
                val item = Item(dataNumber[i], dataFoto.getResourceId(i,-1))
                listItem.add(item)
            }
            return listItem
        }

    private fun showRecycleList(){
        val listItemAdapter = ListItemAdapter(list)
        listItemAdapter.setOnItemClickCallback(object : ListItemAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Item) {
                fun Fragment.makeToast(text:String, duration:Int = Toast.LENGTH_LONG){
                    activity.let {
                        Toast.makeText(it,text,duration).show()
                    }
                }
                makeToast("Kamu memilih")
            }
        })
    }
}