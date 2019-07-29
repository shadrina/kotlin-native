package org.jetbrains.kotlin.backend.konan.serialization

import org.jetbrains.kotlin.backend.common.serialization.DescriptorReferenceDeserializer
import org.jetbrains.kotlin.backend.common.serialization.DescriptorUniqIdAware
import org.jetbrains.kotlin.backend.common.serialization.DeserializedDescriptorUniqIdAware
import org.jetbrains.kotlin.backend.common.serialization.UniqIdKey
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.name.FqName

// This is all information needed to find a descriptor in the
// tree of deserialized descriptors. Think of it as base + offset.
// packageFqName + classFqName + index allow to localize some deserialized descriptor.
// Then the rest of the fields allow to find the needed descriptor relative to the one with index.
class KonanDescriptorReferenceDeserializer(
    currentModule: ModuleDescriptor,
    resolvedForwardDeclarations: MutableMap<UniqIdKey, UniqIdKey>)
    : DescriptorReferenceDeserializer(currentModule, resolvedForwardDeclarations),
      DescriptorUniqIdAware by DeserializedDescriptorUniqIdAware {

    // TODO: these are dummies. Eliminate them.
    override fun resolveSpecialDescriptor(fqn: FqName): DeclarationDescriptor = currentModule
    override fun checkIfSpecialDescriptorId(id: Long): Boolean = false
    override fun getDescriptorIdOrNull(descriptor: DeclarationDescriptor): Long? = null
}
