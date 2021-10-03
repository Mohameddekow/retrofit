package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.adapter.MyAdapter
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.model.Post
import com.example.retrofit.repository.Repository

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel


    //private val myAdapter: MyAdapter = MyAdapter()
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setting up recyclerView
        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        //initializing the viw model
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


        /**** using POST method   ****/
        viewModel.pushPost2(2,3, "moha", "android dev")

        viewModel.myResponse.observe(this, Observer { response ->

            if (response.isSuccessful){
                Log.d("Push", response.body().toString())
                Log.d("Message", response.message())
                Log.d("Code", response.code().toString())
            }else{
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }

        })



        /**** getting custom post   ****/

//        viewModel.getCustomPost(2, "id", "desc")
//        viewModel.myCustomPost.observe(this, Observer { response ->
//
//            if (response.isSuccessful){
//
//                response.body()?.let { myAdapter.setData(it) }
//                Log.d("Body", response.body().toString())
//                Log.d("Body", response.message())
//                Log.d("Code", response.code().toString())
//
//            }else{
//
//                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
//
//            }
//
//        })



//        val option: HashMap<String, String> = HashMap()
//        option["_sort"] = "id"
//        option["_order"] = "desc"
//
//        binding.btnGet.setOnClickListener {
//            val number = binding.editText.text.toString()
//            viewModel.getCustomPost2(Integer.parseInt(number), option)
//
//            viewModel.myCustomPost2.observe(this, Observer { response ->
//
//                if (response.isSuccessful){
//
//                    binding.textView.text = response.body().toString()
//
//
//                    //to see the response in logcat
//                    response.body()?.forEach {
//                        Log.d("response", it.userId.toString())
//                        Log.d("response", it.id.toString())
//                        Log.d("response", it.title)
//                        Log.d("response", it.body)
//                        Log.d("Response", "-------------------------------------------------")
//                    }
//
//                }else{
//
//                    binding.textView.text = response.code().toString()
//                }
//            })
//
//        }








//        binding.btnGet.setOnClickListener {
//            val number = binding.editText.text.toString()
//            viewModel.getCustomPost(Integer.parseInt(number),"id", "asc")
//
//            viewModel.myCustomPost.observe(this, Observer { response ->
//
//                if (response.isSuccessful){
//
//                    binding.textView.text = response.body().toString()
//
//                    response.body()?.forEach {
//                        Log.d("response", it.userId.toString())
//                        Log.d("response", it.id.toString())
//                        Log.d("response", it.title)
//                        Log.d("response", it.body)
//                        Log.d("Response", "-------------------------------------------------")
//                    }
//
//                }else{
//
//                    binding.textView.text = response.code().toString()
//                }
//            })
//
//        }





//        binding.btnGet.setOnClickListener {
//            val number = binding.editText.text.toString()
//            viewModel.getPost2(Integer.parseInt(number))
//
//            viewModel.myResponse2.observe(this, Observer { response ->
//                if (response.isSuccessful){
//                    binding.textView.text = response.body().toString()
//                }else{
//                    binding.textView.text = response.code().toString()
//                }
//            })
//        }


    }

    private fun setupRecyclerView(){
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager  = LinearLayoutManager(this)

    }
}