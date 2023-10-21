plugins {
    id("io.papermc.paperweight.userdev")

    id("xyz.jpenilla.run-paper")

    id("root-plugin")
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    paperweight.paperDevBundle("1.20.2-R0.1-SNAPSHOT")
}

tasks {
    runServer {
        jvmArgs("-Dnet.kyori.ansi.colorLevel=truecolor")

        minecraftVersion("1.20.2")
    }

    val jarsDir = File("$rootDir/jars")

    assemble {
        if (jarsDir.exists()) jarsDir.delete() else jarsDir.mkdirs()

        dependsOn(reobfJar)
    }

    reobfJar {
        outputJar.set(file("$jarsDir/${rootProject.name}-${rootProject.version}.jar"))
    }
}