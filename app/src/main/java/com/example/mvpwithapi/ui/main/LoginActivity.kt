package com.example.mvpwithapi.ui.main

import android.util.Log
import android.widget.Button
import butterknife.OnClick
import com.example.mvpwithapi.R
import com.example.mvpwithapi.base.view.BaseActivity

class LoginActivity : BaseActivity<LoginPresenter>(), LoginContract.View {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun attachView() = mPresenter.onAttach(this)

    override fun setUp() {

    }

    override fun handleError(errorCode: Int?, throwable: Throwable?) {

    }

    @OnClick(R.id.btnLogin)
    fun onLogin() {
        mPresenter.login()
    }

    override fun loginSuccess() {
        Log.d("LoginActivity", "loginSuccess")
    }

    override fun loginError() {
        Log.d("LoginActivity", "loginError")
    }


}
