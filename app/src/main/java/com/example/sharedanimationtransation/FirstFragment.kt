package com.example.sharedanimationtransation

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView


class FirstFragment : Fragment(R.layout.fragment_first) {

    lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rv)
        recyclerView.apply {
            adapter = ProductsAdapter() { imageView: ImageView, position ->
                val extras =
                    FragmentNavigatorExtras(
                        imageView to "image $position",
                    )
                findNavController().navigate(
                    R.id.action_firstFragment_to_secondFragment,
                    bundleOf("position" to position),
                    null,
                    extras
                )
            }

        }
        postponeEnterTransition()
        recyclerView.doOnPreDraw {
            startPostponedEnterTransition()
        }

    }
}