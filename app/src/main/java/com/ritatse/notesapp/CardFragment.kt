package com.ritatse.notesapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        view?.let {
            Picasso.with(context).load(imageIdList.getRandom()).into(it.image)
        }
    }
}