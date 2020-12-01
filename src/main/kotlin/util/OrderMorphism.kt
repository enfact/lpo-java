package util

class OrderMorphism {
    companion object {
        fun check(a: ArrayList<Int>, b: ArrayList<Int>): Boolean {
            val p: ArrayList<Pair<Int, Int>> = ArrayList()
            for (i in 0 until a.size) {
                p.add(Pair(a[i], b[i]))
            }
            val pSorted = p.sortedWith(compareBy({ it.first }, { it.second }))
            for (i in 1 until pSorted.size) {
                if (pSorted[i].first > pSorted[i - 1].first)
                    if (pSorted[i].second <= pSorted[i - 1].second) return false
                if (pSorted[i].first == pSorted[i - 1].first)
                    if (pSorted[i].second != pSorted[i - 1].second) return false
            }
            return true;
        }
    }
}