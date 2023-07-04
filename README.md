# Message Definitions

This repository contains the protobuf definitions for platform wide messages.

## Pre-Requisites

- [Buf](https://docs.buf.build/installation)
- [pre-commit](https://pre-commit.com/) to format and lint protobuf files using a git pre-commit hook.
- [make](https://www.gnu.org/software/make/)
- [Java](https://openjdk.org/)
- [Python](https://www.python.org/)

## Suggested Tools/Plugins

- (If using IntelliJ) Install the [buf plugin](https://plugins.jetbrains.com/plugin/19147-buf-for-protocol-buffers).

## Quick Start

- Install all [Pre-Requisites](#pre-requisites).
- Run `pre-commit install` to install the pre-commit hooks into your locally checked out repository.
- Run `make help` to see a list of commands and what they do.

## Recommended Reading

- We follow [The Official Buf Style Guide](https://buf.build/docs/best-practices/style-guide/).
- We make use of the [protoc-gen-validate](https://github.com/bufbuild/protoc-gen-validate) plugin for validation rules.

## Releases

Releases are created by a Gitlab pipeline when version tags are added to the repo.
