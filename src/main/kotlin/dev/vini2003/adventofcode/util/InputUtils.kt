package dev.vini2003.adventofcode.util

import java.io.InputStream
import java.net.URL

object InputUtils {
	fun getInput(day: Int): URL {
		return ResourceUtils.getResource("/dev/vini2003/adventofcode/input/day_${day}")
	}
}