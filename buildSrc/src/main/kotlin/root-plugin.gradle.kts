plugins {
    `java-library`
}

repositories {
    maven("https://repo.triumphteam.dev/snapshots/")

    maven("https://repo.crazycrew.us/releases/")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of("17"))
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }
}