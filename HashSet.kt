class MyHashSet {

    private val bucketSize: Int = 1000
    private val secondaryBucket = bucketSize + 1
    private val storage: Array<BooleanArray?> = Array(bucketSize) { null }
    private fun getFirstHash(key: Int): Int = key % bucketSize
    private fun getSecondHash(key: Int): Int = key / secondaryBucket
    fun add(key: Int) {
        val hashedIndex = getFirstHash(key)
        val index = getSecondHash(key)
        if (storage[hashedIndex] == null) {
            storage[hashedIndex] = BooleanArray(secondaryBucket)
        }
        storage[hashedIndex]!![index] = true
    }
    fun remove(key: Int) {
        val hashedIndex = getFirstHash(key)
        val index = getSecondHash(key)
        if(storage[hashedIndex] != null){
            storage[hashedIndex]!![index] = false
        }
    }
    fun contains(key: Int): Boolean {
        val hashedIndex = getFirstHash(key)
        val index = getSecondHash(key)
        return if (storage[hashedIndex] != null){
            storage[hashedIndex]!![index]
        } else
            false
    }
}
