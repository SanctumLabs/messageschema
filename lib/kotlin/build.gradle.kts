import java.net.URI

buildscript {
  repositories {
    mavenCentral()
  }
}

group = "com.sanctumlabs"
plugins {
  apply(plugin = "java-library")
  apply(plugin = "maven-publish")
}


repositories {
  mavenCentral()
  mavenLocal()

  maven {
    url = uri("https://jitpack.io")
    url = URI.create("https://plugins.gradle.org/m2/")
  }
}

dependencies {
  api("org.jetbrains.kotlin:kotlin-stdlib:1.8.22")
  api("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.22")
  api("com.google.protobuf:protobuf-java:3.22.3")
  api("com.google.protobuf:protobuf-kotlin:3.23.4")
  api("build.buf.protoc-gen-validate:pgv-java-stub:1.0.0")
}

java {
  withSourcesJar()
}

configure<PublishingExtension> {
  repositories {
    maven {
      name = "GithubPackages"
      url = uri("https://maven.pkg.github.com/sanctumlabs/messagedefs")
      credentials {
        username = System.getenv("GH_RELEASE_ACTOR")
        password = System.getenv("GH_PACKAGE_TOKEN")
      }
    }

    // uncomment when we have a public/private repository on Maven
//        maven {
//            name = "OSSRH"
//            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
//            credentials {
//                username = System.getenv("MAVEN_USERNAME")
//                password = System.getenv("MAVEN_PASSWORD")
//            }
//        }
  }

  publications {
    register<MavenPublication>("gpr") {
      from(components["java"])
    }
  }
}