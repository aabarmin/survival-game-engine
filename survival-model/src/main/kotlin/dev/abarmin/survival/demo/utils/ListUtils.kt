package dev.abarmin.survival.demo.utils

/**
 * Concat a few lists together as
 *
 * @author Aleksandr Barmin
 */
fun <T> concat(vararg lists: List<T>): List<T> {
    val result: MutableList<T> = ArrayList<T>()
    for (list in lists) {
        result.addAll(list)
    }
    return result
}

/**
 * Add an element to the beginning of the collection.
 */
fun <T> addFirst(item: T, list: List<T>): List<T> {
    val result = ArrayList<T>()
    result.add(item)
    result.addAll(list)
    return result
}