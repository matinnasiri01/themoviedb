pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        maven("https://repo.spring.io/release")
        maven("https://repository.jboss.org/maven2")
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://repo.spring.io/release")
        maven("https://repository.jboss.org/maven2")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "themoviedb"
include(":app")
include(":core:database")
include(":core:network")
include(":data")
include(":domain")
include(":feature:home")
include(":feature:search")
include(":feature:favourite")
include(":feature:details")
