package org.example.project

class Date(
    val day:Int,
    val month: Int,
    val year: Int,
    val era: EraDesignator = EraDesignator.CE,
) {

}

enum class EraDesignator() {
    BCE, CE
}