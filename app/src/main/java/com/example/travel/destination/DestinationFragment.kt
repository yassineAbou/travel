package com.example.travel.destination

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travel.R
import com.example.travel.city.CityItemListener
import com.example.travel.databinding.FragmentDestinationBinding
import com.example.travel.city.CityItemsAdapter
import com.example.travel.city.listOfCities
import com.example.travel.databinding.ActivityMainBinding.inflate


class DestinationFragment : Fragment() {

    private lateinit var binding: FragmentDestinationBinding
    private val destinationViewModel: DestinationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentDestinationBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)

        setupAdapter()
        setupDestinationViewModel()
        destinationViewModel.displayDestinations(listOfCities)

        return binding.root
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> destinationViewModel.showAlert(requireContext())
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
         inflater.inflate(R.menu.destination_menu, menu)
    }



    private fun setupDestinationViewModel() {
        binding.apply {
            destination = destinationViewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    private fun setupAdapter() {
        val adapter = CityItemsAdapter(CityItemListener { destinationViewModel.showAlert(requireContext()) })
        binding.destinationRecyclerview.adapter = adapter
        val manager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
        binding.destinationRecyclerview.layoutManager = manager
    }


}