package com.bela.andversion

import android.app.Application
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.bela.andversion.model.data.Android
import com.bela.andversion.model.service.AndroidServiceUseCase
import com.bela.andversion.viewmodel.ListViewModel
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
//@RunWith(MockitoJUnitRunner::class)
//@RunWith(RobolectricTestRunner::class)
@RunWith(JUnit4::class)
class ExampleUnitTest {
    val context = ApplicationProvider.getApplicationContext<Context>()
    //val activity?: MainActivity
    @Mock
    private lateinit var mockContext: Context
    @Mock
    private lateinit var listViewmodel: ListViewModel
    @Mock
    private lateinit var androidService: AndroidServiceUseCase

    //***************Test functions*****************

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    //Probar si la llamada del RX funciona
    @Test
    fun testCallRxJava(){

        //Given : Pre conditions, mock all needed
        listViewmodel = ListViewModel(application = Application())
        //androidService = AndroidServiceUseCase()
        //val list : Single<List<Android>> = androidService.getAndroidObjects()
        //When: Call refresh method
        when(listViewmodel.refresh()){
            //Then: Verify liveData has the value i am searching
            println("Then was successful") ->
                testErrorMessage()
        }


    }

    //Probar q el error está retornando un mensaje de error
    @Test
    fun testErrorMessage(){

    }

    //Mock: Cambiarle el nombre al atributo name y probar que pasa con el parseo
    @Test
    fun testAttributeNameChanged(){

    }
}
