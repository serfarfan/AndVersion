package com.bela.andversion

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.bela.andversion.model.service.AndroidService
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {
    val context = ApplicationProvider.getApplicationContext<Context>()
    @Mock
    private lateinit var mockContext: Context

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    //Probar si la llamada del RX funciona
    @Test
    fun testCallRxJava(){
        val androidServiceUnderTest = AndroidService()
    }

    //Probar q el error está retornando un mensaje de error
    @Test
    fun testErrorMessage(){

    }

    //mock: Cambiarle el nombre al atributo name y probar que pasa con el parseo
    @Test
    fun testAttributeNameChanged(){

    }
}
