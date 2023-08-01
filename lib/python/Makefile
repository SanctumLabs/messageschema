# define standard colors
ifneq (,$(findstring xterm,${TERM}))
	BLACK        := $(shell tput -Txterm setaf 0)
	RED          := $(shell tput -Txterm setaf 1)
	GREEN        := $(shell tput -Txterm setaf 2)
	YELLOW       := $(shell tput -Txterm setaf 3)
	LIGHTPURPLE  := $(shell tput -Txterm setaf 4)
	PURPLE       := $(shell tput -Txterm setaf 5)
	BLUE         := $(shell tput -Txterm setaf 6)
	WHITE        := $(shell tput -Txterm setaf 7)
	RESET := $(shell tput -Txterm sgr0)
else
	BLACK        := ""
	RED          := ""
	GREEN        := ""
	YELLOW       := ""
	LIGHTPURPLE  := ""
	PURPLE       := ""
	BLUE         := ""
	WHITE        := ""
	RESET        := ""
endif

.PHONY: help
help: ## describe all commands
	@grep -E '^[a-zA-Z_]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

.PHONY: default
default: build

.PHONY: clean
clean: ## removes packaged python library
	rm -rf dist/ messageschema.egg-info/

.PHONY: install
install: ## install Python dependencies
	pip install -r requirements.txt

.PHONY: build
build: clean ## build python package
	pip install -r requirements.txt
	find sanctumlabs -type d -exec touch {}/__init__.py \;
	touch sanctumlabs/py.typed
	python -m build

.PHONY: publish-pypi
publish-pypi: build ## publish python package to PyPI
	twine upload --verbose -u '__token__' dist/*

.PHONY: publish-gitlab
publish-gitlab: build ## publish python package to Gitlab package registry
	TWINE_PASSWORD=${CI_JOB_TOKEN} TWINE_USERNAME=gitlab-ci-token twine upload --repository-url ${CI_API_V4_URL}/projects/${CI_PROJECT_ID}/packages/pypi dist/*`
