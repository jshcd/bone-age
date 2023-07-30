package es.jshcd.edadosea.ui

import junit.framework.TestCase.assertEquals
import org.junit.Test
import es.jshcd.edadosea.R
import org.junit.Assert.assertThrows

internal class BonesHelperKtTest {

    @Test
    fun test_getBoneById_zero() {
        assertEquals(R.string.bone_radius, getBoneById(0))
    }

    @Test
    fun test_getBoneById_one() {
        assertEquals(R.string.bone_ulna, getBoneById(1))
    }

    @Test
    fun test_getBoneById_two() {
        assertEquals(R.string.bone_first_metacarpal, getBoneById(2))
    }

    @Test
    fun test_getBoneById_three() {
        assertEquals(R.string.bone_third_metacarpal, getBoneById(3))
    }

    @Test
    fun test_getBoneById_four() {
        assertEquals(R.string.bone_fifth_metacarpal, getBoneById(4))
    }

    @Test
    fun test_getBoneById_five() {
        assertEquals(R.string.bone_thumb_proximal_phalange, getBoneById(5))
    }

    @Test
    fun test_getBoneById_six() {
        assertEquals(R.string.bone_third_finger_proximal_phalange, getBoneById(6))
    }

    @Test
    fun test_getBoneById_seven() {
        assertEquals(R.string.bone_fifth_finger_proximal_phalange, getBoneById(7))
    }

    @Test
    fun test_getBoneById_eight() {
        assertEquals(R.string.bone_third_finger_intermediate_phalange, getBoneById(8))
    }

    @Test
    fun test_getBoneById_nine() {
        assertEquals(R.string.bone_fifth_finger_intermediate_phalange, getBoneById(9))
    }

    @Test
    fun test_getBoneById_ten() {
        assertEquals(R.string.bone_thumb_distal_phalange, getBoneById(10))
    }

    @Test
    fun test_getBoneById_eleven() {
        assertEquals(R.string.bone_third_finger_distal_phalange, getBoneById(11))
    }

    @Test
    fun test_getBoneById_twelve() {
        assertEquals(R.string.bone_fifth_finger_distal_phalange, getBoneById(12))
    }

    @Test
    fun test_getBoneById_greater_than_twelve() {
        assertThrows(UnexpectedBoneException::class.java) {
            getBoneById(13)
        }
    }

    @Test
    fun test_getBoneById_Negative() {
        assertThrows(UnexpectedBoneException::class.java) {
            getBoneById(-1)
        }
    }

    @Test
    fun test_getPossibleStadiosByBone_zero() {
        assertEquals(listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"), getPossibleStadiosByBone(0))
    }

    @Test
    fun test_getPossibleStadiosByBone_one() {
        assertEquals(listOf("A", "B", "C", "D", "E", "F", "G", "H",), getPossibleStadiosByBone(1))
    }

    @Test
    fun test_getPossibleStadiosByBone_two() {
        assertEquals(listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"), getPossibleStadiosByBone(2))
    }

    @Test
    fun test_getPossibleStadiosByBone_three() {
        assertEquals(listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"), getPossibleStadiosByBone(3))
    }

    @Test
    fun test_getPossibleStadiosByBone_four() {
        assertEquals(listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"), getPossibleStadiosByBone(4))
    }

    @Test
    fun test_getPossibleStadiosByBone_five() {
        assertEquals(listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"), getPossibleStadiosByBone(5))
    }

    @Test
    fun test_getPossibleStadiosByBone_six() {
        assertEquals(listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"), getPossibleStadiosByBone(6))
    }

    @Test
    fun test_getPossibleStadiosByBone_seven() {
        assertEquals(listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"), getPossibleStadiosByBone(7))
    }

    @Test
    fun test_getPossibleStadiosByBone_eigth() {
        assertEquals(listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"), getPossibleStadiosByBone(8))
    }

    @Test
    fun test_getPossibleStadiosByBone_nine() {
        assertEquals(listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"), getPossibleStadiosByBone(9))
    }

    @Test
    fun test_getPossibleStadiosByBone_ten() {
        assertEquals(listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"), getPossibleStadiosByBone(10))
    }

    @Test
    fun test_getPossibleStadiosByBone_eleven() {
        assertEquals(listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"), getPossibleStadiosByBone(11))
    }

    @Test
    fun test_getPossibleStadiosByBone_twelve() {
        assertEquals(listOf("A", "B", "C", "D", "E", "F", "G", "H", "I"), getPossibleStadiosByBone(12))
    }

    @Test
    fun test_getPossibleStadiosByBone_more_than_twelve() {
        assertThrows(UnexpectedBoneException::class.java) {
            getPossibleStadiosByBone(13)
        }
    }

    @Test
    fun test_getPossibleStadiosByBone_negative() {
        assertThrows(UnexpectedBoneException::class.java) {
            getPossibleStadiosByBone(-1)
        }
    }

    @Test
    fun test_getDrawableIdByBone_zero() {
        assertEquals(R.drawable.radio, getDrawableIdByBone(0))
    }

    @Test
    fun test_getDrawableIdByBone_one() {
        assertEquals(R.drawable.cubito, getDrawableIdByBone(1))
    }

    @Test
    fun test_getDrawableIdByBone_two() {
        assertEquals(R.drawable.primer_metacarpiano, getDrawableIdByBone(2))
    }

    @Test
    fun test_getDrawableIdByBone_three() {
        assertEquals(R.drawable.tercer_metacarpiano, getDrawableIdByBone(3))
    }

    @Test
    fun test_getDrawableIdByBone_four() {
        assertEquals(R.drawable.quinto_metacarpiano, getDrawableIdByBone(4))
    }

    @Test
    fun test_getDrawableIdByBone_five() {
        assertEquals(R.drawable.falange_proximal_del_pulgar, getDrawableIdByBone(5))
    }

    @Test
    fun test_getDrawableIdByBone_six() {
        assertEquals(R.drawable.falange_proximal_del_tercer_dedo, getDrawableIdByBone(6))
    }

    @Test
    fun test_getDrawableIdByBone_seven() {
        assertEquals(R.drawable.falange_proximal_del_quinto_dedo, getDrawableIdByBone(7))
    }

    @Test
    fun test_getDrawableIdByBone_eight() {
        assertEquals(R.drawable.falange_media_del_tercer_dedo, getDrawableIdByBone(8))
    }

    @Test
    fun test_getDrawableIdByBone_nine() {
        assertEquals(R.drawable.falange_media_del_quinto_dedo, getDrawableIdByBone(9))
    }

    @Test
    fun test_getDrawableIdByBone_ten() {
        assertEquals(R.drawable.falange_distal_del_pulgar, getDrawableIdByBone(10))
    }

    @Test
    fun test_getDrawableIdByBone_eleven() {
        assertEquals(R.drawable.falange_distal_del_tercer_dedo, getDrawableIdByBone(11))
    }

    @Test
    fun test_getDrawableIdByBone_twelve() {
        assertEquals(R.drawable.falange_distal_del_quinto_dedo, getDrawableIdByBone(12))
    }

    @Test
    fun test_getDrawableIdByBone_more_than_twelve() {
        assertThrows(UnexpectedBoneException::class.java) {
            getDrawableIdByBone(13)
        }
    }

    @Test
    fun test_getDrawableIdByBone_negative() {
        assertThrows(UnexpectedBoneException::class.java) {
            getDrawableIdByBone(-1)
        }
    }
}