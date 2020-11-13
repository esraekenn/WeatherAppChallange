package com.example.weatherapp.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentLoginBinding
import com.example.weatherapp.network.RetrofitClient
import com.example.weatherapp.network.WeatherApiService
import com.example.weatherapp.network.model.LoginRequest
import com.example.weatherapp.network.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private var userName: String = ""
    private var password: String = ""
    val loginRequest = LoginRequest()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login, container, false
        )

        binding.btnLogin.setOnClickListener {
            requestToTheService()
        }
        return binding.root
    }


    fun requestToTheService() {
        userName = binding.edtUserName.text.toString()
        loginRequest.userName = userName
        password = binding.edtPassword.text.toString()
        loginRequest.password = Integer.parseInt(password)

        RetrofitClient.getClient().create(WeatherApiService::class.java)
            .getMovieResponse(loginRequest).enqueue(object :
                Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.v("onFail", "${t.message}")

                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    response.body()?.let {
                        if (userName == "test32" && password == "123456" ) {
                            val data= Bundle()
                            data.putString("jwtToken", it.jwtToken)
                            data.putString("refreshToken", it.refreshToken)

                            findNavController().navigate(R.id.weatherListFragment,data)
                        }
                    } ?: kotlin.run {

                        Toast.makeText(
                            context,
                            "Kullanıcı adı veya şifre hatalı",
                            Toast.LENGTH_LONG
                        ).show()
                    } }
            })
    }

}