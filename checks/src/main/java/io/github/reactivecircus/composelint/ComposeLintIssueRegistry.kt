package io.github.reactivecircus.composelint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import io.github.reactivecircus.composelint.detector.ComposableFunctionNameDetector

@Suppress("UnstableApiUsage")
class ComposeLintIssueRegistry : IssueRegistry() {
    override val issues: List<Issue> = listOf(ComposableFunctionNameDetector.ISSUE)

    override val api: Int = CURRENT_API
}
