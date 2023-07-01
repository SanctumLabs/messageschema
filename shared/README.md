# Shared

Shared message schemas used across the library.

## Pre-requisites

Have [Buf](https://docs.buf.build/installation) CLI installed locally

## Setup

Run the below command to update the lock file with the correct dependencies

```shell
buf mod update
```

> This updates the current module with the correct hashes of the versions used.

Normally, you would not need to run this on every `git pull/git clone` command of the repository. This is necessary when a new dependency is added to the [buf.yaml](./buf.yaml) file.
