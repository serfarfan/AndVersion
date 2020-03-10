package com.bela.andversion

import android.app.Application
import com.bela.andversion.model.data.Android
import com.bela.andversion.model.service.AndroidService
import com.bela.andversion.model.service.AndroidServiceUseCase
import com.bela.andversion.viewmodel.ListViewModel
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class ListViewModelTest {

    //Mock objects
    private var androidService = mock(AndroidService::class.java)
    private var androidServiceUseCase = mock(AndroidServiceUseCase::class.java)
    private lateinit var application: Application
    private lateinit var listViewModel: ListViewModel


    @Before
    fun setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        androidServiceUseCase = AndroidServiceUseCase(androidService)
        application = Application()
        listViewModel = ListViewModel(application)

    }

    @Test
    fun init() {
        //Given
        val itemsAndroid= listOf(1..5).map {
            mock(Android::class.java)
        }
        val observable = Single.just(itemsAndroid)
        Mockito.`when`(androidServiceUseCase.invoke()).thenReturn(observable)
        //When
        val response = androidServiceUseCase.invoke()
        //Then
        response.subscribe { list -> assert(itemsAndroid == list) }
    }

}