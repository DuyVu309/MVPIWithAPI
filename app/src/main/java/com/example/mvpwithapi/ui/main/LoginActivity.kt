package com.example.mvpwithapi.ui.main

import android.widget.Toast
import butterknife.OnClick
import com.example.mvpwithapi.R
import com.example.mvpwithapi.base.view.BaseActivity

class LoginActivity : BaseActivity<LoginPresenter>(), LoginContract.View {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun attachView() = mPresenter.onAttach(this)

    override fun setUp() {

    }

    override fun handleError(errorCode: Int?, throwable: Throwable?) {
        Toast.makeText(this, throwable.toString(), Toast.LENGTH_LONG).show()
    }

    @OnClick(R.id.btnLogin)
    fun onLogin() {
        mPresenter.login()
    }

    override fun loginSuccess(data: String) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show()
    }

    override fun loginError() {
        Toast.makeText(this, "loginError", Toast.LENGTH_LONG).show()
    }
}
