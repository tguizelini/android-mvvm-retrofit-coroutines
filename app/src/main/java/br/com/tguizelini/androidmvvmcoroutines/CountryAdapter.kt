package br.com.tguizelini.androidmvvmcoroutines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*
import java.util.ArrayList

class CountryAdapter(private val items: ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val countryName = view.countryName

        fun bind(country: Country) {
            countryName.text = country.name
        }
    }

    fun update(countries: List<Country>) {
        items.clear()
        items.addAll(countries)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
    )

}