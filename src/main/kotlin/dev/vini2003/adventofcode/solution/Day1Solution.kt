package dev.vini2003.adventofcode.solution

import dev.vini2003.adventofcode.util.BenchmarkUtils
import java.net.URL

object Day1Solution : Solution(1, 25_000) {
	override fun solvePart1(input: URL): String {
		val result =
			input.readText()
				.split('\n')
				.filter(String::isNotBlank)
				.map(String::toInt)
				.let { depths ->
					depths.mapIndexed { index, depth ->
						index > 0 && index < depths.size && depth > depths[index - 1]
					}
				}.sumOf { boolean ->
					boolean.compareTo(false)
				}
		
		
		return "$result"
	}
	
	override fun solvePart2(input: URL): String {
		val result =
			input.readText()
				.split('\n')
				.filter(String::isNotBlank)
				.map(String::toInt)
				.let { depths ->
					depths.mapIndexed { index, depth ->
						if (index > 0 && index < depths.size - 2) {
							val nextAverageDepth = depth + depths[index + 1] + depths[index + 2]
							val previousAverageDepth = depths[index - 1] + depth + depths[index + 1]
							
							nextAverageDepth > previousAverageDepth
						} else false
					}
				}.sumOf { boolean ->
					boolean.compareTo(false)
				}
		
		
		return "$result"
	}
}