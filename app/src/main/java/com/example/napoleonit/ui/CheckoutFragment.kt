package com.example.napoleonit.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.napoleonit.R
import com.example.napoleonit.presentation.CheckoutPresenter
import kotlinx.android.synthetic.main.fragment_checkout.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

enum class Type { CARD, CASH }

class CheckoutFragment : MvpAppCompatFragment(R.layout.fragment_checkout), CheckoutView {

    private val presenter : CheckoutPresenter by moxyPresenter {
        CheckoutPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        payBtn.setOnClickListener {
            presenter.validate(
                nameEt.text.toString(),
                surnameEt.text.toString(),
                phoneEt.text.toString()
            )
        }

        rgType.setOnCheckedChangeListener { _, i ->
            val selectedType = when (i) {
                R.id.card -> Type.CARD
                else -> Type.CASH
            }

            presenter.setType(selectedType)
        }
    }

    override fun showNameError() = showErrorToast("Имя должно содержать от 2 до 15 символов")

    override fun showSurnameError() = showErrorToast("Фамилия должна содержать от 2 до 20 символов")

    override fun showPhoneError() =
        showErrorToast("Номер должен начинаться с 8 или +7 и содержать 11 цифр")

    private fun showErrorToast(errMsg: String) =
        Toast.makeText(requireContext(), "Ошибка: $errMsg", Toast.LENGTH_LONG).show()
}