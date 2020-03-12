package com.bela.andversion.model.service

import com.bela.andversion.model.data.Android
import io.reactivex.Single

open class AndroidServiceUseCase constructor(private val androidServiceImp: AndroidService) {

    open operator fun invoke(): Single<List<Android>> = androidServiceImp.getAndroidObjects()

}