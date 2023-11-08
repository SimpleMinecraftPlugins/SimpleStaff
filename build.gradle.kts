plugins {
    id("paper-plugin")
}

rootProject.group = "me.corecraft.staffplus"
rootProject.description = "A staff plugin."
rootProject.version = "0.1"

dependencies {
    // https://github.com/ryderbelserion/Cluster
    compileOnly(libs.cluster.paper)

    // https://github.com/TriumphTeam/triumph-cmds
    compileOnly(libs.triumph.cmds)

    // https://github.com/AuthMe/ConfigMe
    compileOnly(libs.config.me)
}

tasks {
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