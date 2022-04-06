name: verify and publish javadoc on gh-pages

on:
  push:
    branches:
      - main

jobs:
  publish:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
        with:
          fetch-depth: 0
      - uses: actions/setup-java@v2
        with:
          java-version: 17
          distribution: 'adopt'
      - name: Verify project
        run: mvn clean verify -DskipTests
      - name: Deploy javadoc to gh-pages
        uses: JamesIves/github-pages-deploy-action@4.1.8
        with:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          BRANCH: gh-pages
          CLEAN: true
          FOLDER: target/apidocs
          TARGET_FOLDER: /
