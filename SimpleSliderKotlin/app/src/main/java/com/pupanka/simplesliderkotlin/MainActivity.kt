package com.pupanka.simplesliderkotlin

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.pupanka.simplesliderkotlin.databinding.ActivityMainBinding
import com.pupanka.simplesliderkotlin.fragment.IntroFragment
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var adapter : myPagerAdapter
    private var listFrag: ArrayList<IntroFragment> = arrayListOf()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        for (i in 1..4) {
            var fragz = IntroFragment()
            fragz.setImageUrl("https://picsum.photos/seed/picsum/200/300")
            fragz.setTitle("yoho")
            fragz.setSubTitle("yohohoho")
            listFrag.add(fragz)
        }

        adapter = myPagerAdapter(supportFragmentManager)
        adapter.list.addAll(listFrag)

        binding.viewPager.adapter = adapter
//        binding.btnNext.setOnClickListener {
//            binding.viewPager.currentItem++
//        }

        binding.txtBack.visibility = View.GONE
        binding.txtBack.setOnClickListener {
            binding.viewPager.currentItem--
        }

//        txt_continue_start.setOnClickListener {
        binding.txtContinueStart.setOnClickListener {
            binding.viewPager.currentItem++
        }


        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            @SuppressLint("SetTextI18n")
            override fun onPageSelected(position: Int) {
                if(position == adapter.list.size-1){
                    //lastPage
                    binding.txtContinueStart.text = "Done"
                    binding.txtContinueStart.setOnClickListener {
//                        goToDashboard()
                    }
//                    txt_continue_start.setOnClickListener {
//                    txt_continue_start.setOnClickListener {
////                        goToLogin()
//                    }

                    Log.e("xlogx","in B")
//                    binding.btnNext.setText("ajo")
//                    binding.btnNext.visibility = View.GONE
                }else{
                    Log.e("xlogx","in A")
                    //has next
//                    btn_next.text = "Next"
//                    btn_next.setOnClickListener {
//                        view_pager.currentItem++
//                    }
                    //binding.btnNext.visibility = View.GONE
                }

                when(binding.viewPager.currentItem){
                    0->{
                        binding.indicator1.setTextColor(Color.BLACK)
                        binding.indicator2.setTextColor(Color.GRAY)
                        binding.indicator3.setTextColor(Color.GRAY)

                        binding.img1.setImageResource(R.drawable.ic_selected_slider)
                        binding.img2.setImageResource(R.drawable.circle_unselected_selector)
                        binding.img3.setImageResource(R.drawable.circle_unselected_selector)
                        binding.txtBack.visibility = View.GONE
                    }
                    1->{
                        binding.indicator1.setTextColor(Color.GRAY)
                        binding.indicator2.setTextColor(Color.BLACK)
                        binding.indicator3.setTextColor(Color.GRAY)

                        binding.img1.setImageResource(R.drawable.circle_unselected_selector)
                        binding.img2.setImageResource(R.drawable.ic_selected_slider)
                        binding.img3.setImageResource(R.drawable.circle_unselected_selector)
                        binding.txtBack.visibility = View.VISIBLE
                    }
                    2->{
                        binding.indicator1.setTextColor(Color.GRAY)
                        binding.indicator2.setTextColor(Color.GRAY)
                        binding.indicator3.setTextColor(Color.BLACK)

                        binding.img1.setImageResource(R.drawable.circle_unselected_selector)
                        binding.img2.setImageResource(R.drawable.circle_unselected_selector)
                        binding.img3.setImageResource(R.drawable.ic_selected_slider)
                        binding.txtBack.visibility = View.VISIBLE
                    }
                }
            }
        })

    }

    class myPagerAdapter(manager : FragmentManager) : FragmentPagerAdapter(manager){

        val list : MutableList<Fragment> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return list[position]
        }

        override fun getCount(): Int {
            return list.size
        }
    }
}