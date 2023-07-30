package es.jshcd.edadosea.core

const val NUMBER_OF_BONES = 13
const val MALE = 0
const val FEMALE = 1

val RUS_TABLE_MALE = arrayOf(
    intArrayOf(0, 16, 21, 30, 39, 59, 87, 138, 213), // radio
    intArrayOf(0, 27, 30, 32, 40, 58, 107, 181, -1), // cúbito
    intArrayOf(0, 6, 9, 14, 21, 26, 36, 49, 67), // primer metacarpiano
    intArrayOf(0, 4, 5, 9, 12, 19, 31, 43, 52), // tercer metacarpiano
    intArrayOf(0, 4, 6, 9, 14, 18, 29, 43, 52), // quinto metacarpiano
    intArrayOf(0, 7, 8, 11, 17, 26, 38, 52, 67), // falange proximal del pulgar
    intArrayOf(0, 4, 4, 9, 15, 23, 31, 40, 53), // falange proximal del tercer dedo
    intArrayOf(0, 4, 5, 9, 15, 21, 30, 39, 51), // falange proximal del quinto dedo
    intArrayOf(0, 4, 6, 9, 15, 22, 32, 43, 52), // falange media del tercer dedo
    intArrayOf(0, 6, 7, 9, 15, 23, 32, 42, 49), // falange media del quinto dedo
    intArrayOf(0, 5, 6, 11, 17, 26, 38, 46, 66), // falange distal del pulgar
    intArrayOf(0, 4, 6, 8, 13, 18, 28, 34, 49), // falange distal del tercer dedo
    intArrayOf(0, 5, 6, 9, 13, 18, 27, 34, 48) // falange distal del quinto dedo
)

val RUS_TABLE_FEMALE = arrayOf(
    intArrayOf(0, 23, 30, 44, 56, 78, 114, 160, 218), // radio
    intArrayOf(0, 30, 33, 37, 45, 74, 118, 173, -1), // cúbito
    intArrayOf(0, 8, 12, 18, 24, 31, 43, 53, 67), // primer metacarpiano
    intArrayOf(0, 5, 8, 12, 16, 23, 37, 47, 53), // tercer metacarpiano
    intArrayOf(0, 6, 9, 12, 17, 23, 35, 48, 52), // quinto metacarpiano
    intArrayOf(0, 9, 11, 14, 20, 31, 44, 56, 67), // falange proximal del pulgar
    intArrayOf(0, 5, 7, 12, 19, 27, 37, 44, 54), // falange proximal del tercer dedo
    intArrayOf(0, 6, 7, 12, 18, 26, 35, 42, 51), // falange proximal del quinto dedo
    intArrayOf(0, 6, 8, 12, 18, 27, 36, 45, 52), // falange media del tercer dedo
    intArrayOf(0, 7, 8, 12, 18, 28, 35, 43, 49), // falange media del quinto dedo
    intArrayOf(0, 7, 9, 15, 22, 33, 48, 51, 68), // falange distal del pulgar
    intArrayOf(0, 7, 8, 11, 15, 22, 33, 37, 49), // falange distal del tercer dedo
    intArrayOf(0, 7, 8, 11, 15, 22, 32, 36, 47) // falange distal del quinto dedo
)

val POINTS_TABLE_MALE = intArrayOf(
    0, 0, 0, 0, 0, 0, 26, 32, 38, 43, 49, 55, 61, 65, 70,
    75, 80, 84, 89, 93, 98, 101, 105, 108, 112, 115, 118, 122, 125,
    128, 132, 135, 138, 141, 144, 147, 150, 153, 156, 159, 162,
    165, 168, 171, 173, 177, 180, 182, 185, 187, 189, 192, 194,
    197, 199, 202, 204, 207, 209, 212, 215, 128, 222, 224, 227,
    230, 233, 235, 238, 240, 243, 245, 248, 251, 253, 256, 260,
    263, 266, 269, 272, 275, 278, 281, 283, 286, 289, 292, 295,
    297, 300, 303, 306, 309, 312, 316, 319, 321, 325, 328, 330,
    334, 337, 340, 342, 346, 349, 352, 354, 358, 361, 365, 369,
    373, 378, 382, 386, 391, 395, 400, 405, 410, 416, 422, 427,
    434, 440, 447, 454, 463, 472, 481, 490, 501, 512, 524, 536,
    548, 560, 574, 588, 602, 616, 630, 645, 660, 675, 692, 708,
    726, 744, 762, 780, 789, 816, 833, 850, 867, 883, 899, 915,
    928, 940, 951, 962, 971, 980, 986, 992, 995, 997, 999, 1000
)

val POINTS_TABLE_FEMALE = intArrayOf(
    32, 42, 53, 63, 74, 83, 82, 101, 110, 117, 125, 133,
    140, 147, 153, 159, 164, 169, 175, 180, 185, 189, 192, 196,
    200, 203, 207, 210, 214, 217, 221, 224, 227, 230, 232, 235,
    238, 240, 243, 246, 248, 251, 253, 256, 259, 261, 264, 267,
    270, 272, 275, 277, 280, 283, 286, 289, 292, 295, 298, 301,
    303, 307, 310, 314, 318, 321, 324, 327, 330, 334, 337, 341,
    344, 348, 351, 355, 358, 362, 366, 371, 375, 380, 386, 392,
    397, 402, 407, 413, 419, 425, 431, 437, 444, 450, 457, 464,
    471, 478, 485, 493, 500, 507, 515, 523, 530, 538, 545, 553,
    560, 569, 578, 587, 596, 605, 614, 624, 633, 643, 653, 664,
    674, 684, 695, 705, 715, 726, 737, 448, 758, 769, 779, 790,
    801, 812, 822, 834, 847, 859, 873, 886, 900, 915, 929, 942,
    954, 966, 977, 986, 993, 997, 1000
)