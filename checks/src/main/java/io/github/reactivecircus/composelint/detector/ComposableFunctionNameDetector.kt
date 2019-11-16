package io.github.reactivecircus.composelint.detector

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.LintFix
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import com.android.tools.lint.detector.api.SourceCodeScanner
import com.android.tools.lint.detector.api.isJava
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UMethod
import org.jetbrains.uast.asRecursiveLogString
import java.util.EnumSet
import java.util.Locale

@Suppress("UnstableApiUsage", "ReturnCount")
@UseExperimental(ExperimentalStdlibApi::class)
class ComposableFunctionNameDetector : Detector(), SourceCodeScanner {

    companion object {
        val ISSUE: Issue = Issue.create(
            id = "InvalidComposableFunctionName",
            briefDescription = "A function marked with a `@Composable` annotation should start with a capital letter.",
            explanation = """
                It is a convention that `@Composable` functions start with a capital letter \
                to emphasize the mental models that a @Composable function is \
                a **noun** rather than a **verb**.""",
            implementation = Implementation(
                ComposableFunctionNameDetector::class.java, EnumSet.of(
                    Scope.JAVA_FILE
                )
            ),
            priority = 8,
            category = Category.COMPLIANCE,
            severity = Severity.WARNING
        )

        private const val COMPOSABLE_ANNOTATION = "androidx.compose.Composable"
    }

    override fun getApplicableUastTypes(): List<Class<out UElement>>? =
        listOf(UMethod::class.java)


    override fun createUastHandler(context: JavaContext): UElementHandler? {
        val psi = context.uastFile?.sourcePsi ?: return null
        if (isJava(psi)) {
            return null
        }

        return object : UElementHandler() {
            override fun visitMethod(node: UMethod) {
                val methodName = node.name
                if (node.hasAnnotation(COMPOSABLE_ANNOTATION) && methodName.first().isLowerCase()) {
                    context.report(
                        issue = ISSUE,
                        location = context.getLocation(node),
                        message = "`@Composable` function names should be capitalized.",
                        quickfixData = LintFix.create()
                            .replace()
                            .text(methodName)
                            .with(methodName.capitalize(Locale.getDefault()))
                            .build()
                    )
                }
            }
        }
    }
}
