package joz.spekdemo.login

import rx.Scheduler
import rx.schedulers.Schedulers


class LoginPresenter(
        val view: LoginContract.View,
        val interactor: LoginContract.Interactor,
        val viewScheduler: Scheduler
) : LoginContract.Presenter {

    override fun onLoginRequested() {
        view.showProgress()
        makeLoginRequest()
    }

    private fun makeLoginRequest() {
        interactor
                .isUserLoggedIn()
                .subscribeOn(Schedulers.io())
                .observeOn(viewScheduler)
                .subscribe({ isUserLoggedIn ->
                    if (isUserLoggedIn) {
                        view.hideProgress()
                        view.showLoggedInScreen()
                    } else {
                        sendLoginRequest()
                    }
                })
    }

    private fun sendLoginRequest() {
        interactor
                .sendLoginRequest()
                .subscribeOn(Schedulers.io())
                .observeOn(viewScheduler)
                .subscribe({
                    loginResponse ->
                    view.hideProgress()
                    view.showLoggedInScreen()
                }, { e ->
                    view.hideProgress()
                    view.showError()
                })
    }

}