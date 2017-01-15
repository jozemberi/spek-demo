package joz.spekdemo.login

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import joz.spekdemo.MainActivity
import joz.spekdemo.R
import joz.spekdemo.databinding.ActivityLoginBinding
import rx.android.schedulers.AndroidSchedulers

class LoginActivity : AppCompatActivity(), LoginContract.View {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        val presenter = LoginPresenter(this, LoginInteractor(), AndroidSchedulers.mainThread())
        binding.loginButton.setOnClickListener { v -> presenter.onLoginRequested() }
    }

    override fun showLoggedInScreen() {
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun showProgress() {
        binding.loginProgressBar.visibility = View.VISIBLE
        binding.loginButton.visibility = View.GONE
    }

    override fun hideProgress() {
        binding.loginProgressBar.visibility = View.GONE
    }

    override fun showError() {
        binding.loginButton.visibility = View.VISIBLE
        Toast.makeText(this, getString(R.string.error_login), Toast.LENGTH_SHORT).show()
    }

}
