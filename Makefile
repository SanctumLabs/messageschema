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
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

generate: ## generate protobuf code
	@printf "${BLUE}generating protobuf artefacts ... ${RESET}"
	@buf generate
	@printf "${BLUE}done${RESET}"

.PHONY: lint
lint: ## lint protobuf code
	@printf "${BLUE}linting protobuf code  ... ${RESET}"
	@buf lint
	@printf "${BLUE}done${RESET}"

.PHONY: format
format: ## format protobuf code
	@printf "${BLUE}formatting protobuf code ... ${RESET} "
	@buf format -w
	@printf "${BLUE}done${RESET}"

.PHONY: check-for-breaking-changes
check-for-breaking-changes: ## check for breaking changes against the main branch
	 @buf breaking --against '.git#branch=main'

.PHONY: java-publish-local
java-publish-local: ## publish java protobuf package to the local maven repository as a snapshot package e.g make java-publish-local version=0.7.0-SNAPSHOT
	@printf "${YELLOW}removing previous java build artefacts ... ${RESET}"
	@rm -rf lib/java/build lib/java/src
	@printf "${YELLOW}done${RESET}\n"
	@printf "${BLUE}generating protobuf artefacts ... ${RESET}"
	@buf generate
	@printf "${BLUE}done${RESET}\n"
	@printf "${GREEN}publishing to maven local ... ${GREEN}"
ifdef version
	@cd lib/java;./gradlew clean; ./gradlew publishToMavenLocal -Pversion=$(version); cd ../..
else
	@cd lib/java;./gradlew clean;./gradlew publishToMavenLocal; cd ../..
endif
	@printf "${GREEN}done${RESET}\n"
