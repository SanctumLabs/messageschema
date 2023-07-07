# Message Definitions Python library

Message definitions library in Python.

## Setup

First create a virtual environment. This will require installing [virtualenv](https://virtualenv.pypa.io/). Additionally, you will require [pip](https://pypi.org/project/pip/) installed as well.

``` shell
virtualenv .venv
```

> This creates a virtual environment in the current directory

Now, you can install the dependencies with:

```shell
pip install -r requirements
```

Or with make:

```shell
make install
```

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
