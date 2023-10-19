plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"

    id("io.papermc.paperweight.userdev") version "1.5.7"

    `java-library`
}

rootProject.group = "me.corecraft.StaffPlus"
rootProject.description = "A staff plugin."
rootProject.version = "0.1"

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")

    maven("https://repo.crazycrew.us/releases/")
}

dependencies {
    // https://github.com/ryderbelserion/Cluster
    implementation("com.ryderbelserion.cluster", "cluster-paper", "2.1")

    // https://github.com/AuthMe/ConfigMe
    implementation("ch.jalu", "configme", "1.4.1")

    paperweight.paperDevBundle("1.20.2-R0.1-SNAPSHOT")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of("17"))
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }

    val jarsDir = File("$rootDir/jars")

    assemble {
        if (jarsDir.exists()) jarsDir.delete() else jarsDir.mkdirs()

        dependsOn(reobfJar)
    }

    reobfJar {
        outputJar.set(file("$jarsDir/${rootProject.name}-${rootProject.version}.jar"))
    }

    processResources {
        val props = mapOf(
            "name" to rootProject.name,
            "group" to rootProject.group,
            "version" to rootProject.version,
            "description" to rootProject.description,
            "apiVersion" to "1.20",
        )

        filesMatching("paper-plugin.yml") {
            expand(props)
        }
    }
}