package com.pupanka.simplesliderkotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pupanka.simplesliderkotlin.databinding.FragmentIntroBinding

class IntroFragment : Fragment() {
    private var url : String = ""
    private var img : Int = 0
    private var pageTitle : String = ""
    private var pageSubTitle : String = ""

    private lateinit var binding: FragmentIntroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if(url.isNotEmpty()){
            Glide.with(requireContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(binding.imgSlider)
        }else{
            binding.imgSlider.setImageResource(img)
        }

        binding.fragmentTitle.text = pageTitle
        binding.fragmentSubtitle.text = pageSubTitle
    }

    fun setImage(_img : Int){
        img = _img
    }

    fun setImageUrl(_url : String){
        url = _url
    }

    fun setTitle(title : String){
        pageTitle = title
    }

    fun setSubTitle(subTitle : String){
        pageSubTitle = subTitle
    }
}