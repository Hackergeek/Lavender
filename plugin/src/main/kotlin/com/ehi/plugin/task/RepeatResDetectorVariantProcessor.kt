package com.ehi.plugin.task

import com.android.build.gradle.api.BaseVariant
import com.android.build.gradle.internal.api.ApplicationVariantImpl
import com.ehi.plugin.spi.VariantProcessor
import com.google.auto.service.AutoService
import org.gradle.api.Project

/**
 * Author: Omooo
 * Date: 2019/9/27
 * Version: v0.1.0
 * Desc: 注册 RepeatResDetectorTask
 * @see RepeatResDetectorTask
 */
@AutoService(VariantProcessor::class)
class RepeatResDetectorVariantProcessor : VariantProcessor {
    override fun process(project: Project, variant: BaseVariant) {
        val tasks = project.tasks
        tasks.findByName("repeatRes") ?: tasks.create(
            "repeatRes",
            RepeatResDetectorTask::class.java
        )
    }
}