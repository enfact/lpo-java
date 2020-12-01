package util

import org.junit.Test

import org.junit.Assert.*

class OrderMorphismTest {

    @Test
    fun checkTest() {
        val a: ArrayList<Int> = arrayListOf(1,2,3,4,5)
        val b: ArrayList<Int> = arrayListOf(3,4,5,6,9)
        val c: ArrayList<Int> = arrayListOf(4,2,1,4,5)
        val d: ArrayList<Int> = arrayListOf(9,4,2,9,10)
        val e: ArrayList<Int> = arrayListOf(9,4,2,9,9)
        assert(OrderMorphism.check(a,b))
        assert(OrderMorphism.check(c,d))
        assert(!OrderMorphism.check(c,e))
        assert(!OrderMorphism.check(c,a))
        assert(!OrderMorphism.check(e,a))
    }
}