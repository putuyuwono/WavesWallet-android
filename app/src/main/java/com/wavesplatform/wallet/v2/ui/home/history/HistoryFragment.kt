package com.wavesplatform.wallet.v2.ui.home.history

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.flyco.tablayout.listener.OnTabSelectListener
import com.wavesplatform.wallet.R
import com.wavesplatform.wallet.v2.ui.base.view.BaseFragment
import com.wavesplatform.wallet.v2.ui.home.history.adapter.HistoryFragmentPageAdapter
import kotlinx.android.synthetic.main.fragment_history.*
import pers.victor.ext.toast
import javax.inject.Inject

class HistoryFragment : BaseFragment(), HistoryView {

    @Inject
    @InjectPresenter
    lateinit var presenter: HistoryPresenter

    @ProvidePresenter
    fun providePresenter(): HistoryPresenter = presenter

    override fun configLayoutRes(): Int = R.layout.fragment_history

    companion object {

        /**
         * @return HistoryFragment instance
         * */
        fun newInstance(): HistoryFragment {
            return HistoryFragment()
        }
    }

    override fun onViewReady(savedInstanceState: Bundle?) {
        setupUI()
    }

    private fun setupUI() {
        viewpager_history.adapter = HistoryFragmentPageAdapter(childFragmentManager, arrayOf(getString(R.string.history_all), getString(R.string.history_sent),getString(R.string.history_received)))

        stl_history.setViewPager(viewpager_history)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_history, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.action_sorting -> {
                toast(item.title)
            }
        }

        return super.onOptionsItemSelected(item)
    }

}
