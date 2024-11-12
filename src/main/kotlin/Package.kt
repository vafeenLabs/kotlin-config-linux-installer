package ru.vafeen

class Package(
    name: String,
    val process: ((String) -> String)? = null,
    val customCommand: String? = null
) {
    var packageName: String = name
        get() {
            packageCalls.plusOrThrow(packageName = field)
            return field
        }
    private var packageCalls = 0
    private fun Int.plusOrThrow(packageName: String): Int =
        if (this < 1) this + 1 else throw Exception("$packageName more than 1")
}