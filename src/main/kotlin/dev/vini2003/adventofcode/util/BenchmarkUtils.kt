package dev.vini2003.adventofcode.util

import java.util.concurrent.TimeUnit

object BenchmarkUtils {
	fun <T> getAverageMs(iterations: Int, code: () -> T): BenchmarkResult<T> {
		var count = 0F
		var total = 0F
		
		var result: T? = null
		
		for (i in 0..iterations) {
			val then = System.nanoTime()
			
			if (result == null) {
				result = code()
			} else {
				code()
			}
			
			val now = System.nanoTime()
			
			val ms = TimeUnit.MILLISECONDS.convert(now - then, TimeUnit.NANOSECONDS)
			
			if (i > 0) {
				count += 1F
				total += ms
			}
		}
		
		return BenchmarkResult(count, total, total / count, result!!)
	}
	
	data class BenchmarkResult<T>(val count: Float, val total: Float, val average: Float, val result: T)
}