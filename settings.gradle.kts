pluginManagement {
    repositories {
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
    }
}

rootProject.name = "ThirdEventStudy"
include(":app")

include (":EventBus")
include (":eventbus-android")
include (":EventBusAnnotationProcessor")

project(":EventBus").name = "eventbus-java"
project(":EventBusAnnotationProcessor").name = "eventbus-annotation-processor"