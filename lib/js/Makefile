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
clean: ## removes packaged JS library
	rm -rf dist/

.PHONY: install
install: ## install Javascript dependencies
	npm install

.PHONY: build
build: clean ## build package
	npm run build
	cp README.md ./dist
	cp package.json ./dist

.PHONY: publish-npm
publish-npm: build ## publish js package to NPM
	npm publish ./dist

.PHONY: publish-gitlab
publish-gitlab: build ## publish js package to Gitlab package registry
	NPM_TOKEN=${CI_JOB_TOKEN} npm publish ./dist
