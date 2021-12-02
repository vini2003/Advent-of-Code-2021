package dev.vini2003.adventofcode.solution

import java.net.URL

object Day2Solution : Solution(2021, 2, 5_000) {
	override fun solvePart1(input: URL): String {
		val lines = input.readText().trimEnd().lines()
		
		var forward =0
		var depth = 0
		
		lines.forEach { line ->
			val value = line.substringAfter(' ').toInt()
			
			when (line[0]) {
				'f' -> forward += value
				'u' -> depth -= value
				'd' -> depth += value
			}
		}
		
		return "${forward * depth}"
	}
	
	override fun solvePart2(input: URL): String {
		val lines = input.readText().trimEnd().lines()
		
		var aim = 0
		var depth = 0
		var forward = 0
		
		lines.forEach { line ->
			val value = line.substringAfter(' ').toInt()
			
			when (line[0]) {
				'f' -> {
					forward += value
					depth += value * aim
				}
				
				'u' -> aim -= value
				'd' -> aim += value
			}
		}
		
		return "${forward * depth}"
	}
}