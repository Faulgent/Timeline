package org.example.project

class Period(
    val startDate: Date,
    val endDate: Date
) {
    val length = endDate.year - if(startDate.era == EraDesignator.BCE) startDate.year*2 else startDate.year
}
