package dev.vini2003.adventofcode.util

import java.io.InputStream
import java.net.URL

object ResourceUtils {
	fun getResource(path: String): URL {
		return object {}.javaClass.getResource(path)
	}
}