package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    constructor (copy: MyDate) : this(copy.year, copy.month, copy.dayOfMonth)

    override operator fun compareTo(other: MyDate): Int {

        if (this.year - other.year != 0) return this.year - other.year

        if (this.month - other.month != 0) return this.month - other.month

        if (this.dayOfMonth - other.dayOfMonth != 0) return this.dayOfMonth - other.dayOfMonth

        return 0
    }

    operator fun plus(interval: TimeInterval): MyDate = addTimeIntervals(interval, 1)

    operator fun plus(interval: RepeatedTimeInterval): MyDate = addTimeIntervals(interval.interval, interval.times)
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {

    override fun iterator(): Iterator<MyDate> {
        return object:Iterator<MyDate> {
            var currentDate = start

            override fun hasNext(): Boolean = if (currentDate <= endInclusive) true else false

            override fun next(): MyDate {
                try {
                    return currentDate
                } finally {
                    currentDate = currentDate.nextDay()
                }
            }
        }
    }
}

class RepeatedTimeInterval(val interval: TimeInterval, val times: Int)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

    operator fun times(t: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, t)
}

