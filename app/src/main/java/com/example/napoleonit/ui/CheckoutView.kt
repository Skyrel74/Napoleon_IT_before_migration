package com.example.napoleonit.ui

import moxy.MvpView
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface CheckoutView : MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun showNameError()

    @StateStrategyType(SkipStrategy::class)
    fun showSurnameError()

    @StateStrategyType(SkipStrategy::class)
    fun showPhoneError()
}