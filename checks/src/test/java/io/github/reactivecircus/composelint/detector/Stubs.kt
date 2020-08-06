package io.github.reactivecircus.composelint.detector

import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.checks.infrastructure.TestFiles.kotlin

@Suppress("UnstableApiUsage")
object Stubs {
    val COMPOSABLE_ANNOTATION: TestFile = kotlin(
        "androidx/compose/runtime/Composable.kt",
        """
            package androidx.compose.runtime
            @Retention(AnnotationRetention.BINARY)
            @Target(
                AnnotationTarget.FUNCTION,
                AnnotationTarget.TYPE,
                AnnotationTarget.TYPE_PARAMETER,
                AnnotationTarget.PROPERTY
            )
            annotation class Composable
        """.trimIndent()
    ).indented().within("src")
}
