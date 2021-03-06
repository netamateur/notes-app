package com.ritatse.notesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ritatse.notesapp.NavigationActivity.Companion.imageIdList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.flipbook_card.view.*

class CardFragment : Fragment() {

    fun Array<Int>.getRandom(): Int {
        return this[(0..this.size - 1).random()]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.flipbook_card, container, false)

        view.rootCard.setOnClickListener { view ->
            generateRandomImage()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        generateRandomImage()
    }

    fun generateRandomImage() {

        val displayMetrics = requireContext().resources.displayMetrics
        val height = displayMetrics!!.heightPixels
        val width = displayMetrics!!.widthPixels

        view?.let {
            Picasso.get().load(imageIdList.getRandom())
//                .placeholder(R.drawable.placeholder)
//                .error(R.drawable.error)
                .resize(width, height / 3)
                .centerCrop()
                .into(it.image)
        }
    }
}