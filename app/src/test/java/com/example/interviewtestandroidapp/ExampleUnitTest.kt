package com.example.interviewtestandroidapp
import androidx.test.InstrumentationRegistry.getTargetContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.interviewtestandroidapp.screens.validation


import org.junit.Assert.*
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun validation_isCorrect_without_email() {

        val context = InstrumentationRegistry.getInstrumentation().getTargetContext()
        val email = ""
        val pass = "admin1234"

        val reslut = validation(context,email,pass)

        assertEquals(false,reslut)

    }

    @Test
    fun validation_isCorrect_without_pass() {

        val context = InstrumentationRegistry.getInstrumentation().getTargetContext()
        val email = "mohib@gmail.com"
        val pass = ""

        val reslut = validation(context,email,pass)

        assertEquals(false,reslut)

    }

    @Test
    fun validation_isCorrect_without_email_and_pass() {

        val context = InstrumentationRegistry.getInstrumentation().getTargetContext()
        val email = ""
        val pass = ""

        val reslut = validation(context,email,pass)

        assertEquals(false,reslut)

    }

    @Test
    fun validation_isCorrect_with_email_and_pass() {

        val context = InstrumentationRegistry.getInstrumentation().getTargetContext()
        val email = "mohib@gmail.com"
        val pass = "admin1234"

        val reslut = validation(context,email,pass)

        assertEquals(true,reslut)

    }


}