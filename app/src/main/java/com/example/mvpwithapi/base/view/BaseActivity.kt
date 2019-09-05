package com.example.mvpwithapi.base.view

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder
import com.example.mvpwithapi.base.presenter.BasePresenter
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity<P : BasePresenter<*, *>> : AppCompatActivity(), IBaseView {

    @Inject
    protected lateinit var mPresenter: P
    private lateinit var mUnBinder: Unbinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        AndroidInjection.inject(this)
        mUnBinder = ButterKnife.bind(this)
        attachView()
        setUp()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun attachView()

    abstract fun setUp()

    override fun onDestroy() {
        mPresenter.onDetach()
        mUnBinder.unbind()
        super.onDestroy()
    }

    override fun hideLoading() {
        //TODO
    }

    override fun showLoading() {
        //TODO
    }

}