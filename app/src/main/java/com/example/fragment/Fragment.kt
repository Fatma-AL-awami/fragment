package com.example.fragment

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import java.util.Observer

class Fragment : Fragment() {
    private lateinit var studentRecyclerView: RecyclerView
     private var adapter: studentAdapter? = studentAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    private val studentListViewModel: model by lazy {
        ViewModelProviders.of(this).get(model::class.java)
    }
    private fun updateUI(student: List<student>) {

       val student = studentListViewModel.students
        adapter = studentAdapter(student)
        studentRecyclerView.adapter = adapter
        //val adapt = studentRecyclerView.adapter as studentAdapter

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.the_fragment, container, false)
        studentRecyclerView = view.findViewById(R.id.student_recycler_view) as RecyclerView
        studentRecyclerView.layoutManager = LinearLayoutManager(context)
        // studentRecyclerView.adapter = adapter
       // updateUI()
        return view
    }

    companion object {
        fun newInstance(): Fragment {
            return Fragment()
        }
    }


   class studentHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        private lateinit var student: student
        val nameTextView: TextView = itemView.findViewById(R.id.stu_name)
        val idTextView: TextView = itemView.findViewById(R.id.stu_id)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(student: student) {

            this.student = student
            nameTextView.text = this.student.name
            idTextView.text = this.student.id.toString()

        }

       override fun onClick(v: View?) {
           TODO("Not yet implemented")
       }
   }

    private inner class studentAdapter(var student: List<student>) : RecyclerView.Adapter<studentHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): studentHolder {
            val view = layoutInflater.inflate(R.layout.activity_list_item_student, parent, false)
            return studentHolder(view)
        }
        override fun getItemCount() = student.size
        override fun onBindViewHolder(holder: studentHolder, position: Int) {
            val student = student[position]

            holder.bind(student)
        }}


}