import java.net.URI

val gitlabGroupID: String by project
val gitlabProjectID: String by project
val gitLabTokenName: String by project
val gitLabPrivateToken: String by project
val version: String by project

buildscript {
  repositories {
    mavenCentral()
  }
}

group = "com.sanctumlabs"

plugins {
  java
  `maven-publish`
  `java-library`
  signing
}

repositories {
  mavenCentral()
  mavenLocal()

  maven {
    url = uri("https://jitpack.io")
    url = URI.create("https://plugins.gradle.org/m2/")
  }

  maven {
    name = "GitLab"
    url = uri("https://gitlab.com/api/v4/groups/${gitlabGroupID}/-/packages/maven")
    credentials(HttpHeaderCredentials::class) {
      name = System.getProperty("GITLAB_TOKEN_NAME", gitLabTokenName)
      value = System.getProperty("GITLAB_PRIVATE_TOKEN", gitLabPrivateToken)
    }
    authentication {
      create<HttpHeaderAuthentication>("header")
    }
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
  withJavadocJar()
  withSourcesJar()
}

publishing {

  publications {
    create<MavenPublication>("library") {
      from(components["java"])
      pom {
        name.set("Messageschema Library")
        description.set("Message schema library containing message schemas for platform wide messages")
        // TODO: update library website page
        url.set("https://github.com/SanctumLabs/messageschema")
        licenses {
          license {
            name.set("The Apache License, Version 2.0")
            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
          }
        }
        developers {
          developer {
            name.set("SanctumLabs")
            email.set("sanctumlabs@gmail.com")
          }
        }
      }
    }
  }

  repositories {
    maven {
      name = "Github"
      url = uri("https://maven.pkg.github.com/sanctumlabs/messageschema")
      credentials {
        username = System.getenv("GH_RELEASE_ACTOR")
        password = System.getenv("GH_PACKAGE_TOKEN")
      }
    }

    maven {
      name = "GitLab"
      url = uri("https://gitlab.com/api/v4/projects/${gitlabProjectID}/packages/maven")
      credentials(HttpHeaderCredentials::class) {
        name = System.getProperty("GITLAB_TOKEN_NAME", gitLabTokenName)
        value = System.getProperty("GITLAB_PRIVATE_TOKEN", gitLabPrivateToken)
      }
      authentication {
        create("header", HttpHeaderAuthentication::class)
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
}

signing {
  val signingKey: String? by project
  val signingPassword: String? by project
  useInMemoryPgpKeys(signingKey, signingPassword)
  sign(publishing.publications["library"])
}

tasks {
  javadoc {
    if (JavaVersion.current().isJava9Compatible) {
      (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
  }
}
