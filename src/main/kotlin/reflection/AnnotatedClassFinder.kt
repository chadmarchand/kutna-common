package com.chadmarchand.reflection

import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.type.filter.AnnotationTypeFilter

private const val ANNOTATION_SEARCH_PACKAGE_PROPERTY_NAME = "ANNOTATION_SEARCH_BASE_PACKAGE"

fun findClassesWithAnnotation(annotationType: Class<Annotation>, basePackage: String): Set<BeanDefinition> {
    val scanner = ClassPathScanningCandidateComponentProvider(true)

    scanner.addIncludeFilter(AnnotationTypeFilter(annotationType))

    return scanner.findCandidateComponents(System.getProperty(ANNOTATION_SEARCH_PACKAGE_PROPERTY_NAME))
}
