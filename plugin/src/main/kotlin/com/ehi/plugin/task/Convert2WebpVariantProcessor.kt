package com.ehi.plugin.task

import com.android.build.gradle.api.BaseVariant
import com.ehi.plugin.spi.VariantProcessor
import com.google.auto.service.AutoService
import org.gradle.api.Project

/**
 * Author: Omooo
 * Date: 2020/2/11
 * Version: v0.1.1
 * Desc: 注册 Convert2WebpTask
 * @see Convert2WebpTask
 */
@AutoService(VariantProcessor::class)
class Convert2WebpVariantProcessor : VariantProcessor {

    override fun process(project: Project, variant:BaseVariant) {
        val tasks = project.tasks
        val convert2WebpTask = tasks.findByName("convert2Webp") ?: tasks.create(
            "convert2Webp",
            Convert2WebpTask::class.java
        )
        val mergeResourcesTask = variant.mergeResourcesProvider.get()
        mergeResourcesTask.dependsOn(convert2WebpTask)
    }
}