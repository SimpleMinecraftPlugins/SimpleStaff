plugins {
    id("paper-plugin")

    //kotlin("jvm") version "1.9.10"
}

rootProject.group = "me.corecraft.staffplus"
rootProject.description = "A staff plugin."
rootProject.version = "0.1"

dependencies {
    compileOnly(libs.jetbrains.kotlin)

    // https://github.com/ryderbelserion/Cluster
    compileOnly(libs.cluster.paper)

    // https://github.com/TriumphTeam/triumph-cmds
    compileOnly(libs.triumph.cmds)

    // https://github.com/AuthMe/ConfigMe
    compileOnly(libs.config.me)
}

//kotlin {
//    jvmToolchain(17)
//}

tasks {
    //compileKotlin {
    //    kotlinOptions {
    //        jvmTarget = "17"
    //        javaParameters = true
    //    }
    //}

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