package joz.spekdemo.login

import joz.spekdemo.entities.LoginResponse
import rx.Observable

interface LoginContract {

    interface View {
        fun showLoggedInScreen()
        fun showProgress()
        fun hideProgress()
        fun showError()
    }

    interface Interactor {
        fun isUserLoggedIn(): Observable<Boolean>
        fun sendLoginRequest(): Observable<LoginResponse>
    }

    interface Presenter {
        fun onLoginRequested()
    }

}
