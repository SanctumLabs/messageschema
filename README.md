# Message Schema

This repository contains the protobuf schema definitions for platform wide messages. This is useful for platforms that communicate using a
defined message schema over the wire and need a harmonized common way of handling message communication, in this case Protobuf. This could also
be used to send messages to message brokers and queues that know how to serialize & deserialize protocol buffer message types, for example [Kafka](https://kafka.apache.org/).

This has been built to generate code that can be used in projects of different languages, making it language agnostic. Currently, the code generation is
done using [buf](https://buf.build/docs/introduction) and the languages that are generated are:

1. Python
2. Kotlin
3. Golang
4. JavaScript

The schemas themselves are published to a buf registry making it easer to use in languages that have no code generates set here yet.

Additionally, packages for the respective languages are generated and published to respective repositories or package registries.

For Python, this is [PyPI](https://pypi.org/) and this can be found [here](https://pypi.org/project/sanctumlabs-messageschema/).
Kotlin can be found [here](https://github.com/SanctumLabs/messageschema/packages/1923287), JavaScript can be found [here](https://github.com/SanctumLabs/messageschema/pkgs/npm/messageschema) & [here](https://www.npmjs.com/package/@sanctumlabs/messageschema).

Note that the same packages are also published to Gitlab Package Registry which follow the same versioning format.

## Pre-Requisites

In order to setup the project, you will need a couple of things first setup locally:

- [Buf](https://docs.buf.build/installation) to handle code generation
- [make](https://www.gnu.org/software/make/) for running convenience scripts in Makefiles.
- [Java](https://openjdk.org/)
- [Gradle](https://gradle.org/) Build tool to generate builds for JVM based projects, in this case Kotlin in [kotlin](./lib/kotlin/)
- [Python](https://www.python.org/) to handle Python generated code in [python](./lib/python/)
- [NPM](https://www.npmjs.com/) to handle package management and installation of dependencies for the JS based project in [js](./lib/js/)
- [Go](https://go.dev/) for the generated go code in [go](./lib/go)

## Suggested Tools/Plugins

- (If using IntelliJ) Install the [buf plugin](https://plugins.jetbrains.com/plugin/19147-buf-for-protocol-buffers).

## Quick Start

- Install all [Pre-Requisites](#pre-requisites).
- Run `pre-commit install` to install the pre-commit hooks into your locally checked out repository.
- Run `make help` to see a list of commands and what they do.

## Recommended Reading

- We follow [The Official Buf Style Guide](https://buf.build/docs/best-practices/style-guide/).
- We make use of the [protoc-gen-validate](https://github.com/bufbuild/protoc-gen-validate) plugin for validation rules.
- More documentation can be found [here](./docs/)

## Releases

Releases are created by a Gitlab pipeline when version tags are added to the repo. This is all automated and no manual intervention is needed other than to trigger a build manually. The release versions are created based of the commit messages using tool [commitlint](https://commitlint.js.org/#/), [cz-cli](https://github.com/commitizen/cz-cli) & [semantic-release](https://semantic-release.gitbook.io/semantic-release/v/beta/).

Note that there are 2 set of pipelines that run:

1. [GitLab Pipelines](https://docs.gitlab.com/ee/ci/pipelines/)
2. [Github Actions](https://docs.github.com/en/actions)

GitLab Pipelines runs lint, build and generates the buf schemas and publishes them to the buf registry also publishes the language packages to [GitLab Package Registry](https://docs.gitlab.com/ee/user/packages/) which is private for now. Github Actions handles the same processes but is triggered by Gitlab Pipelines & will publish the package to Github Package Registry for Maven & NPM & to NPM & PyPI also triggering a Github release. These are public.

Github & Bitbucket act as mirror repositories with the former for public use while GitLab is for private use.

