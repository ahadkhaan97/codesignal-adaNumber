fun main() {
    print(solution("123_456_789"))
}

fun solution(line: String): Boolean {
    val numStr = line.replace("_", "")
    if (numStr.matches(Regex("""\d+"""))) {
        return true
    }
    val regex = """(\d+)#([0-9a-fA-F]+)#""".toRegex()
    val matchResult = regex.matchEntire(numStr) ?: return false
    val base = matchResult.groupValues[1].toIntOrNull()
    if (base == null || base !in 2..16) {
        return false
    }
    val num = matchResult.groupValues[2]
    if (num.isEmpty() || num.startsWith("0") && num.length > 1) {
        return false
    }
    val digits = "0123456789ABCDEF".substring(0, base)
    return num.all { it.uppercaseChar() in digits }
}

