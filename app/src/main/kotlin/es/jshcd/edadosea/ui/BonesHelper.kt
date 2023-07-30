package es.jshcd.edadosea.ui

import es.jshcd.edadosea.R

@Throws(UnexpectedBoneException::class)
fun getBoneById(boneId: Int): Int {
    return when(boneId) {
        0  -> R.string.bone_radius
        1 -> R.string.bone_ulna
        2 -> R.string.bone_first_metacarpal
        3 -> R.string.bone_third_metacarpal
        4 -> R.string.bone_fifth_metacarpal
        5 -> R.string.bone_thumb_proximal_phalange
        6 -> R.string.bone_third_finger_proximal_phalange
        7 -> R.string.bone_fifth_finger_proximal_phalange
        8 -> R.string.bone_third_finger_intermediate_phalange
        9 -> R.string.bone_fifth_finger_intermediate_phalange
        10 -> R.string.bone_thumb_distal_phalange
        11 -> R.string.bone_third_finger_distal_phalange
        12 -> R.string.bone_fifth_finger_distal_phalange
        else -> throw UnexpectedBoneException()
    }
}

@Throws(UnexpectedBoneException::class)
fun getPossibleStadiosByBone(boneId: Int): List<String> {
    return when(boneId) {
        0 -> listOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
        1 -> listOf("A", "B", "C", "D", "E", "F", "G", "H")
        2 -> listOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
        3 -> listOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
        4 -> listOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
        5 -> listOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
        6 -> listOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
        7 -> listOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
        8 -> listOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
        9 -> listOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
        10 -> listOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
        11 -> listOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
        12 -> listOf("A", "B", "C", "D", "E", "F", "G", "H", "I")
        else -> throw UnexpectedBoneException()
    }
}

@Throws(UnexpectedBoneException::class)
fun getDrawableIdByBone(boneId: Int): Int {
    return when(boneId) {
        0 -> R.drawable.radio
        1 -> R.drawable.cubito
        2 -> R.drawable.primer_metacarpiano
        3 -> R.drawable.tercer_metacarpiano
        4 -> R.drawable.quinto_metacarpiano
        5 -> R.drawable.falange_proximal_del_pulgar
        6 -> R.drawable.falange_proximal_del_tercer_dedo
        7 -> R.drawable.falange_proximal_del_quinto_dedo
        8 -> R.drawable.falange_media_del_tercer_dedo
        9 -> R.drawable.falange_media_del_quinto_dedo
        10 -> R.drawable.falange_distal_del_pulgar
        11 -> R.drawable.falange_distal_del_tercer_dedo
        12 -> R.drawable.falange_distal_del_quinto_dedo
        else -> throw UnexpectedBoneException()
    }
}

class UnexpectedBoneException: Exception()