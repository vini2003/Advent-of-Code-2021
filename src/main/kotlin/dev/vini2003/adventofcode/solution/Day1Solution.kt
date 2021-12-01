package dev.vini2003.adventofcode.solution

import java.net.URL

object Day1Solution : Solution(1) {
	override fun solvePart1(input: URL): String {
		val lines = input.readText().split('\n')
		var lastDepth = lines.first().toInt()
		
		var timesDepthIncreased = 0
		
		lines.drop(1).forEach { line ->
			if (line.isNotBlank()) {
				if (line.toInt() > lastDepth) {
					++timesDepthIncreased
				}
				
				lastDepth = line.toInt()
			}
			
		}
		
		return "$timesDepthIncreased"
	}
	
	override fun solvePart2(input: URL): String {
		val lines = input.readText().split('\n')
		var lastDepth = lines.take(3).sumOf(String::toInt)
		
		var timesDepthIncreased = 0
		
		lines.forEachIndexed { index, line ->
			if (index > 2 && lines[index].isNotBlank() && lines[index - 1].isNotBlank() && lines[index - 2].isNotBlank()) {
				var depth = lines[index].toInt() + lines[index - 1].toInt() + lines[index - 2].toInt()
				
				if (depth > lastDepth) {
					++timesDepthIncreased
				}
				
				lastDepth = depth
			}
		}
		
		return "$timesDepthIncreased"
	}
}