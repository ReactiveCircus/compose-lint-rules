package io.github.reactivecircus.composelint.detector

import com.android.tools.lint.checks.infrastructure.TestFiles.kotlin
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import io.github.reactivecircus.composelint.detector.Stubs.COMPOSABLE_ANNOTATION
import org.junit.Test

@Suppress("UnstableApiUsage")
class ComposableFunctionNameDetectorTest {

    @Test
    fun `composable function name starting with capital case`() {
        lint()
            .files(
                COMPOSABLE_ANNOTATION,
                kotlin(
                    """
                import androidx.compose.Composable
                
                @Composable
                fun Greeting(name: String) {
                    Text(text = "Hello " + name + "!")
                }
                """.trimIndent()
                )
            )
            .allowMissingSdk()
            .issues(ComposableFunctionNameDetector.ISSUE)
            .run()
            .expectClean()
    }

    @Test
    fun `composable function name starting with lower case`() {
        lint()
            .files(
                COMPOSABLE_ANNOTATION,
                kotlin(
                    """
                import androidx.compose.Composable
                
                @Composable
                fun greeting(name: String) {
                    Text(text = "Hello " + name + "!")
                }
                """.trimIndent()
                )
            )
            .allowMissingSdk()
            .issues(ComposableFunctionNameDetector.ISSUE)
            .run()
            .expect("""
                src/test.kt:3: Warning: @Composable function names should be capitalized. [LowerCaseComposableFunctionName]
                @Composable
                ^
                0 errors, 1 warnings
            """.trimIndent())
            .expectFixDiffs("""
                Fix for src/test.kt line 3: Replace with Greeting:
                @@ -4 +4
                - fun greeting(name: String) {
                + fun Greeting(name: String) {
            """.trimIndent())
    }

    @Test
    fun `regular function name starting with lower case`() {
        lint()
            .files(
                kotlin(
                    """
                fun greeting(name: String) {
                    println(name)
                }
                """.trimIndent()
                )
            )
            .allowMissingSdk()
            .issues(ComposableFunctionNameDetector.ISSUE)
            .run()
            .expectClean()
    }
}
