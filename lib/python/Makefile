default: build

clean:
	rm -rf dist/ sanctumlabs_models_py.egg-info/

build: clean
	pip install -r requirements.txt
	find sanctumlabs -type d -exec touch {}/__init__.py \;
	touch sanctumlabs/py.typed
	python -m build

publish: build
	twine upload --repository-url https://yocotechnologies.jfrog.io/artifactory/api/pypi/pypi-local dist/*

publish-pypi: build
	twine upload --verbose -u '__token__' dist/*

publish-gitlab: build
	TWINE_PASSWORD=${CI_JOB_TOKEN} TWINE_USERNAME=gitlab-ci-token twine upload --repository-url ${CI_API_V4_URL}/projects/${CI_PROJECT_ID}/packages/pypi dist/*`