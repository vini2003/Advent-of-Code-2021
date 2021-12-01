package dev.vini2003.adventofcode.solution

import com.github.ajalt.mordant.rendering.TextColors.*
import dev.vini2003.adventofcode.util.InputUtils
import terminal
import java.io.InputStream
import java.net.URL

abstract class Solution(val day: Int) {
	fun solve() {
		terminal.println("\uD83D\uDD25 ${brightCyan("Solving day ${day}...")}")

		val part1 = solvePart1(InputUtils.getInput(day))
		
		if (part1 == "not present!") {
			terminal.println(brightRed("=> ⭐  Skipped part one!"))
		} else {
			terminal.println(brightGreen("=> ⭐  Solved part one: ${part1}!"))
		}
		
		val part2 = solvePart2(InputUtils.getInput(day))
		
		if (part2 == "not present!") {
			terminal.println(brightRed("=> ⭐  Skipped part two!"))
		} else {
			terminal.println(brightGreen("=> ⭐⭐ Solved part two: ${part2}!"))
		}
		
		terminal.println(brightYellow("⭐ Solved day ${day}!"))
	}
	
	open fun solvePart1(input: URL): String = "not present!"
	
	open fun solvePart2(input: URL): String = "not present!"
}