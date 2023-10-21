plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"

    id("io.papermc.paperweight.userdev") version "1.5.7"

    id("xyz.jpenilla.run-paper") version "2.2.0"

    kotlin("jvm") version "1.9.10"
}

rootProject.group = "me.corecraft.staffplus"
rootProject.description = "A staff plugin."
rootProject.version = "0.1"

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")

    maven("https://repo.triumphteam.dev/snapshots/")

    maven("https://repo.crazycrew.us/releases/")
}

dependencies {
    compileOnly("org.jetbrains.kotlin","kotlin-stdlib-jdk8","1.9.10")

    // https://github.com/ryderbelserion/Cluster
    implementation("com.ryderbelserion.cluster", "cluster-paper", "2.4")

    // https://github.com/Rollczi/LiteCommands/tree/master
    //compileOnly("dev.rollczi.litecommands","bukkit-adventure", "2.8.9")

    // https://github.com/TriumphTeam/triumph-cmds
    compileOnly("dev.triumphteam", "triumph-cmd-bukkit", "2.0.0-SNAPSHOT")

    // https://github.com/AuthMe/ConfigMe
    compileOnly("ch.jalu", "configme", "1.4.1")

    paperweight.paperDevBundle("1.20.2-R0.1-SNAPSHOT")
}

kotlin {
    jvmToolchain(17)
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of("17"))
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
            javaParameters = true
        }
    }

    runServer {
        jvmArgs("-Dnet.kyori.ansi.colorLevel=truecolor")

        minecraftVersion("1.20.2")
    }

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