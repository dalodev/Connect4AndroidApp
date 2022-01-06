package com.dalodev.connect4.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.dalodev.connect4.ui.base.events.Command
import com.dalodev.connect4.ui.base.events.GeneralCommand
import com.dalodev.connect4.ui.base.events.Route
import com.dalodev.connect4.ui.base.navigation.Navigator
import com.dalodev.connect4.ui.extensions.observeIn
import com.dalodev.connect4.ui.extensions.showLongToast
import com.dalodev.connect4.ui.extensions.showShortToast
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.onEach

abstract class BaseFragment<
        VM : BaseViewModel,
        NA : Navigator
        > : Fragment() {

    private var isViewCreated = false

    protected abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent {
            composableView()
        }
    }

    protected open fun composableView() {
       // Stub
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wasViewCreated = isViewCreated
        isViewCreated = true

        if (!wasViewCreated) {
            onPreInit()
            onInit()
            onPostInit()
        }

        onBindViewModel()

        if (!wasViewCreated) {
            savedInstanceState?.let(::onRestoreState)
        }
    }

    @CallSuper
    protected open fun onPreInit() {
        // Stub
    }

    @CallSuper
    protected open fun onInit() {
        // Stub
    }

    @CallSuper
    protected open fun onPostInit() {
        loadData()
    }

    private fun loadData() {
        lifecycleScope.launchWhenResumed {
            onLoadData()
        }
    }

    protected open fun onLoadData() {
        // Stub
    }

    @CallSuper
    protected open fun onBindViewModel() {
        bindViewModelCommands()
        bindViewModelRoutes()
    }

    private fun bindViewModelCommands() {
        viewModel.commandFlow
            .onEach(::onHandleCommand)
            .observeIn(this)
    }

    private fun bindViewModelRoutes() {
        viewModel.routeFlow
            .onEach(::onRoute)
            .observeIn(this)
    }

    @CallSuper
    protected open fun onHandleCommand(command: Command) {
        when (command) {
            is GeneralCommand.ShowShortToast -> showShortToast(command.message)
            is GeneralCommand.ShowLongToast -> showLongToast(command.message)
        }
    }

    @CallSuper
    protected open fun onRoute(route: Route) {
        // Stub
    }

    @CallSuper
    protected open fun onRestoreState(state: Bundle) {
        // Stub
    }

    final override fun onSaveInstanceState(state: Bundle) {
        onSaveState(state)
        super.onSaveInstanceState(state)
    }

    @CallSuper
    protected open fun onSaveState(state: Bundle) {
        // Stub
    }

    override fun onDestroy() {
        super.onDestroy()
        isViewCreated = false
        viewModel.viewModelScope.cancel()
    }
}