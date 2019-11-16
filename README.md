# Compose Lint Rules

[![CircleCI](https://circleci.com/gh/ReactiveCircus/compose-lint-rules.svg?style=svg)](https://circleci.com/gh/ReactiveCircus/compose-lint-rules)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Android Lint rules for **Jetpack Compose**.

## Download

Dependencies are hosted on [Maven Central][maven-central].

```groovy
implementation "io.github.reactivecircus.composelint:composelint:0.1.0"
```

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].

## Lint Rules

- **InvalidComposableFunctionName** - A function marked with a `@Composable` annotation should start with a capital letter. It is a convention emphasizes the mental models that a `@Composable` function is a **noun** rather than a **verb**.

[maven-central]: https://search.maven.org/search?q=g:io.github.reactivecircus.composelint
[snap]: https://oss.sonatype.org/content/repositories/snapshots/
