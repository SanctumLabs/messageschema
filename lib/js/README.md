# Message Schema JavaScript library

Message schema library in JavaScript. This can be used as the canonical way of carrying message data or event data in a platform between services in a distributed architecture. This is especially useful in an event driven architecture setup where events are how services communicate with each other.

## Setup

First ensure you have [npm](https://www.npmjs.com/) installed locally or [yarn](https://yarnpkg.com/).

``` shell
npm install
```

Or

```shell
yarn install
```

Or you can execute the above with make:

```shell
make install
```

> This will install the dependencies defined in the [package.json](./package.json) file in a node_modules directory.

That should be it.

In order to build a package, the protobuf generated code needs to be build first. This can be done from the root directory of this project with:

```shell
buf generate
```

Or

```shell
make generate
```

Now, the package can be built with:

```shell
make build
```

Other commands can be viewed with:

```shell
make help
```

## Publication

Since publication is to 3 registries, we rely on the CI to handle the publication of this package. Gitlab CI handles publication to Gitlab NPM package
registry while Github workflows publishes to both NPM registry and Github NPM Registry.

Note that the secrets and configuration to publish to these registries are available as secrets in the CI environment and are not pushed to a VCS.

There is a blank [.npmrc](./.npmrc) file that is populated by the CI in order to ensure that the package is published to the appropriate NPM package registry
