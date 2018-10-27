package com.example.iyemon018.fragmentsample001

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ContainerFragment : Fragment() {

    companion object {
        private const val ARG_NO: String = "ARG_NO"

        // Java で言うところのstatic method 呼び出しはこんな感じ。
        // companion object で宣言すればContainerFragment.getInstance(number) で呼び出しできる。
        fun getInstance(number: Int):ContainerFragment {
            val fragment = ContainerFragment()
            val args = Bundle()
            args.putInt(ARG_NO, number)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_container, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val number = arguments?.getInt(ARG_NO, 0)
        view.findViewById<TextView>(R.id.textView).setText("${number} 番目のFragment")
    }

}
