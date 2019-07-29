package org.jetbrains.kotlin.serialization.konan

import org.jetbrains.kotlin.backend.common.serialization.metadata.KlibMetadataDeserializedPackageFragmentsFactory
import org.jetbrains.kotlin.backend.common.serialization.metadata.KlibMetadataPackageFragment
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.descriptors.PackageFragmentDescriptor
import org.jetbrains.kotlin.konan.library.KonanLibrary

interface KonanDeserializedPackageFragmentsFactory : KlibMetadataDeserializedPackageFragmentsFactory {
    fun createSyntheticPackageFragments(
        library: KonanLibrary,
        deserializedPackageFragments: List<KlibMetadataPackageFragment>,
        moduleDescriptor: ModuleDescriptor
    ): List<PackageFragmentDescriptor>
}
