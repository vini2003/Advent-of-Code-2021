package dev.vini2003.adventofcode.solution

import java.net.URL
import kotlin.math.abs
import kotlin.math.max

object Day5Solution : Solution(2021, 5, 1) {
	val NumberRegex = "([0-9]+)".toRegex()
	
	data class Point(val x: Int, val y :Int)
	
	class Line(x1: Int, y1: Int, x2: Int, y2: Int) {
		var points: MutableList<Point> = mutableListOf()
		
		init {
			val iX = (x2 - x1) / max(1, abs(x2 - x1))
			val iY = (y2 - y1) / max(1, abs(y2 - y1))
			var x = x1
			var y = y1
			for (i in 0..max(max(abs(x2) - abs(x1), abs(x1) - abs(x2)), max(abs(y2) - abs(y1), abs(y1) - abs(y2)))) {
				points += Point(x, y)
				
				x += iX
				y += iY
			}
		}
	}
	
	override fun solvePart1(input: URL): String {
		val result = input.readText().trimEnd().lines().filter(String::isNotEmpty).map { line ->
			val matches = NumberRegex.findAll(line).map(MatchResult::value).map(String::toInt).toList()
			
			if (matches[0] != matches[2] && matches[1] != matches[3]) {
				null
			} else {
				Line(matches[0], matches[1], matches[2], matches[3])
			}
			
		}.filterNotNull().flatMap(Line::points).groupingBy { it }.eachCount().filter { it.value > 1 }.count()
		
		return "$result"
	}
	
	override fun solvePart2(input: URL): String {
		val result = input.readText().trimEnd().lines().filter(String::isNotEmpty).map { line ->
			val matches = NumberRegex.findAll(line).map(MatchResult::value).map(String::toInt).toList()
			
			Line(matches[0], matches[1], matches[2], matches[3])
		}.flatMap(Line::points).groupingBy { it }.eachCount().filter { it.value > 1 }.count()
		
		return "$result"
	}
}