# Shared

Shared message schemas used across the library. These are common message schema formats that are used in either events or messages and rarely ever change. For example, the format for an address will most likely remain the same & if a field is ever added or removed, this can still be used across the platform.

## Pre-requisites

Have [Buf](https://docs.buf.build/installation) CLI installed locally

## Setup

Run the below command to update the lock file with the correct dependencies

```shell
buf mod update
```

> This updates the current module with the correct hashes of the versions used.

Normally, you would not need to run this on every `git pull/git clone` command of the repository. This is necessary when a new dependency is added to the [buf.yaml](./buf.yaml) file.

## Publishing

First you need to have an account with [Buf](https://buf.build/) and create a repository. The repository name is what you can use to update the [buf.yaml](./buf.yaml) with the name correct repository name:

```yaml
name: buf.build/<ACCOUNT OR ORGANIZATION NAME>/<REPOSITORY NAME>
deps:
  - buf.build/envoyproxy/protoc-gen-validate

# other config
```

> Note the `name` field, which has the URL to the repository.

Once this is done, ensure you have set the `BUF_USER` and `BUF_API_TOKEN` from what you get from [Buf](https://buf.build/) you can publish the package:

``` shell
buf login
```

> Logs in interactively, your username and token will be asked for

Next, publish:

``` shell
buf push . -t <TAG>
```

> note, the `.`, this is the current directory, if running these commands outside this directory, ensure to use the correct relative path. Note the `<TAG>` as well, this is the version/tag of the repository.
