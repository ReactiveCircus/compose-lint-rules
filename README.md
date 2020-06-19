# Compose Lint Rules

![CI](https://github.com/ReactiveCircus/compose-lint-rules/workflows/CI/badge.svg)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Android Lint rules for **Jetpack Compose**.

## Download

Dependencies are hosted on [Maven Central][maven-central].

```groovy
implementation "io.github.reactivecircus.composelint:composelint:0.1.0"
```

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].

## Lint Rules

- **InvalidComposableFunctionName** - A non-returning function marked with a `@Composable` annotation should start with a capital letter. It is a convention to emphasize the mental model that a `@Composable` function is a **noun** rather than a **verb**.

[maven-central]: https://search.maven.org/search?q=g:io.github.reactivecircus.composelint
[snap]: https://oss.sonatype.org/content/repositories/snapshots/
