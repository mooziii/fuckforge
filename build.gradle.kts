plugins {
    java
    id("io.papermc.paperweight.userdev") version "1.3.5"
    id("xyz.jpenilla.run-paper") version "1.0.6"
}

group = "me.obsilabor"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    paperDevBundle("1.18.1-R0.1-SNAPSHOT")
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(17)
    }
}

