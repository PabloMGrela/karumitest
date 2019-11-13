package com.pickency.karumi

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private val appContext = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun setUp() {
        CounterStorage(appContext).clear()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        assertEquals("com.pickency.karumi", appContext.packageName)
    }

    @Test
    fun whenAValueIsSavedInSPIsRecoveredSuccessfully() {
        val savedValue = 3
        saveValue(savedValue)

        assertEquals(savedValue, CounterStorage(appContext).getCounter())
    }

    @Test
    fun whenGetFromSPForFirstTimeNullIsReturned() {
        assertNull(CounterStorage(appContext).getCounter())
    }

    @Test
    fun whenTwoValuesAreSavedTheSecondOneIsReturned() {
        saveValue(1)
        saveValue(2)
        assertEquals(2, CounterStorage(appContext).getCounter())
    }

    private fun saveValue(value: Int) = CounterStorage(appContext).save(value)
}
