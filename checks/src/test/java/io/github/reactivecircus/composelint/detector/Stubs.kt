package io.github.reactivecircus.composelint.detector

import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.checks.infrastructure.TestFiles.kotlin

object Stubs {
    val COMPOSABLE_ANNOTATION: TestFile = kotlin(
        "androidx/compose/Composable.kt",
        """
            package androidx.compose
            @Retention(AnnotationRetention.BINARY)
            @Target(
                AnnotationTarget.CLASS,
                AnnotationTarget.TYPE,
                AnnotationTarget.TYPE_PARAMETER
            )
            annotation class Composable
        """.trimIndent()
    ).indented().within("src")
}
