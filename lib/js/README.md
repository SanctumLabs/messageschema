# Message Definitions JavaScript library

Message definitions library in JavaScript.

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
