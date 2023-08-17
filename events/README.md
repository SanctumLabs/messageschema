# Events

Contains schema messages that are used to define events in a platform. This is especially useful for an event driven architecture. This allows the platform to have a unified way of communicating events in the system between microservices and decouples this from the services. Services are then aligned on a schema and format of communicating with each other, further reducing coupling and ensuring that events have the same format and aren't restricted to individual services.

Note that an event is something that has already happened & NOT a command that is triggered. These schema messages should be used to define events that have already occurred and not used as commands to trigger an event to occur.

## Pre-requisites

Have [Buf](https://docs.buf.build/installation) CLI installed locally

## Setup

Run the below command to update the lock file with the correct dependencies

```shell
buf mod update
```

> This updates the current module with the correct hashes of the versions used.

Normally, you would not need to run this on every `git pull/git clone` command of the repository. This is necessary when a new dependency is added to the [buf.yaml](./buf.yaml) file.
