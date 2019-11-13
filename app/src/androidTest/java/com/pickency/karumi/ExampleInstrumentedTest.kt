package com.pickency.karumi

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
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
    lateinit var counterStorage: CounterStorage
    lateinit var magicCounter: MagicCounter

    @Before
    fun setUp() {
        magicCounter = MagicCounter(appContext)
        counterStorage = CounterStorage(appContext)
        counterStorage.clear()
    }

    @After
    fun after() {
        counterStorage.clear()
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

        assertEquals(savedValue, counterStorage.getCounter())
    }

    @Test
    fun whenGetFromSPForFirstTimeNullIsReturned() {
        assertNull(counterStorage.getCounter())
    }

    @Test
    fun whenTwoValuesAreSavedTheSecondOneIsReturned() {
        saveValue(1)
        saveValue(2)
        assertEquals(2, counterStorage.getCounter())
    }

    @Test
    fun whenRandomIsLessThan100ValueIsIncrementedOne() {
        val result = magicCounter.increment(5)
        assertEquals(1, result)
    }

    @Test
    fun whenRandomIsMoreThan100ValueIsIncrementedInRandom() {
        val result = magicCounter.increment(500)
        assertEquals(500, result)
    }

    @Test
    fun whenDecreaseIsCalledNumberDecrease() {
        counterStorage.save(100)
        val result = magicCounter.decrement()
        assertEquals(result, 99)
    }

    private fun saveValue(value: Int) = counterStorage.save(value)
}
