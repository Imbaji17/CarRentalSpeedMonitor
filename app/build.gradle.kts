plugins {
    kotlin("jvm")
    application
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}

application {
    mainClass.set("com.carrental.speedmonitor.mainKt")
}
