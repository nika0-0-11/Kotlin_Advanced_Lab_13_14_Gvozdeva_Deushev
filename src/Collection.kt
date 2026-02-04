val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
val solarSystem = rockPlanets + gasPlanets
val newSolarSystem = arrayOf(
    "Mercury",
    "Venus",
    "Earth",
    "Mars",
    "Jupiter",
    "Saturn",
    "Uranus",
    "Neptune",
    "Pluto"
)
fun main() {
    val solarSystem = mutableListOf(
        "Mercury", "Venus", "Earth", "Mars",
        "Jupiter", "Saturn", "Uranus", "Neptune"
    )
    /*for (planet in solarSystem) {
        println(planet)
    }*/

    solarSystem.add("Pluto")
    solarSystem.add(3,"Theia")
    solarSystem[3] = "Future Moon"
    println(solarSystem[3])
    println(solarSystem[9])
    solarSystem.removeAt(9)
    solarSystem.remove("Future Moon")
    println(solarSystem.contains("Pluto"))
    println("Future Moon" in solarSystem)
}