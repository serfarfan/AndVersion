package com.bela.andversion.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bela.andversion.model.data.Android
import com.bela.andversion.model.service.AndroidService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel(application: Application) : AndroidViewModel(application) {
    //by lazy es una promesa de que lo inicializaré, en caso de nunca usarlo el garbage collector lo elimina
    val androidVersions by lazy { MutableLiveData<List<Android>>() }
    val loadError by lazy { MutableLiveData<Boolean>() }
    private val disposable: CompositeDisposable = CompositeDisposable()

    private val androidApiService = AndroidService()

    fun refresh() {
        getAndroidData()
    }

    private fun getAndroidData() {
        disposable.add(
            androidApiService.getAndroidObjects()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Android>>() {
                    override fun onSuccess(androidList: List<Android>) {
                        loadError.value = false
                        androidVersions.value = androidList
                    }

                    override fun onError(e: Throwable) {
                        loadError.value = true
                        e.printStackTrace()
                        Log.e("Error: ", e.localizedMessage)
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}