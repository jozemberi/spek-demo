package joz.spekdemo.login

import joz.spekdemo.entities.LoginResponse
import rx.Observable
import java.util.concurrent.TimeUnit


class LoginInteractor : LoginContract.Interactor {

    override fun isUserLoggedIn(): Observable<Boolean> {
        return Observable.just(false).delay(1, TimeUnit.SECONDS)
    }

    override fun sendLoginRequest(): Observable<LoginResponse> {
        return Observable.just(LoginResponse()).delay(3, TimeUnit.SECONDS)
    }

}