# Messages

Defines the message schemas which will contain different types of payload events. The messages defined here need not necessarily use the event schemas from [events](../events/), but could be used to compose messages that contain the events as payloads further making it easer to have 1 unified message type. But, again, this is not a hard requirement and these message schemas could be used to transport message data over the wire, for example, HTTP requests from 1 service to another via [gRPC](https://grpc.io/) for example.

## Pre-requisites

Have [Buf](https://docs.buf.build/installation) CLI installed locally

## Setup

Run the below command to update the lock file with the correct dependencies

```shell
buf mod update
```

> This updates the current module with the correct hashes of the versions used.

Normally, you would not need to run this on every `git pull/git clone` command of the repository. This is necessary when a new dependency is added to the [buf.yaml](./buf.yaml) file.
