# Bone Age Calculator

Android application designed for pediatricians and radiologists to calculate the bone age of pediatric patients using the **TW3 (Tanner-Whitehouse 3)** methodology.

## How it works

The application guides the user through a systematic assessment of 13 key bones in a hand radiography:
*   Radius
*   Ulna
*   Metacarpals (1st, 3rd, and 5th)
*   Proximal Phalanges (1st, 3rd, and 5th)
*   Intermediate Phalanges (3rd and 5th)
*   Distal Phalanges (1st, 3rd, and 5th)

For each bone, the user compares the patient's X-ray with reference stages and selects the most appropriate developmental level. Once all bones are assessed and the patient's sex is specified, the app calculates the skeletal maturity and provides the estimated bone age in years and months.

## How to use

1.  **Bone Assessment**: The app will present each of the 13 bones sequentially.
    *   Observe the reference image and description for each stage.
    *   Select the stage that best matches the patient's X-ray.
    *   You can tap on the reference image to view it in **full-screen mode** with zoom capabilities for a more detailed comparison.
2.  **Navigation**: Use the **Next** and **Previous** buttons to move between bones.
3.  **Sex Selection**: After assessing all 13 bones, indicate whether the patient is **Male** or **Female**.
4.  **Results**: Click on **Calculate Bone Age** to see the final assessment. If any input is inconsistent or the patient is considered an adult by the algorithm, an error message will be displayed.

## Scientific Background

This application was developed by **Javier Sánchez Hernández** and is based on:
*   The PhD thesis of **Miguel-Angel Martin** (University of Valladolid, Spain).
*   The research article: *"A Computational TW3 Classifier for Skeletal Maturity Assessment. A Computing with Words Approach"* by S. Aja-Fernandez, R. de Luis-Garcia, M. A. Martin-Fernandez, and C. Alberola-Lopez. Published in the **Journal of Biomedical Informatics**, Vol. 37, pp. 99-107, 2004.

## Evolution of the Project

*   **v1.8**:
    *   Support for Android 15 (API 36).
    *   Implemented full Edge-to-Edge interface with proper window inset handling.
    *   Improved UI responsiveness and status bar integration.
*   **v1.7**:
    *   Migration to **Jetpack Compose** for a modern, declarative UI.
    *   Implementation of Material Design 2 theme.
    *   Added support for Light and Dark themes.
*   **v1.1 - v1.6**:
    *   Enhanced image viewing with zoom functionality.
    *   Improved navigation flow between bone assessments.
    *   Multilingual support (English and Spanish).
*   **v1.0**:
    *   Initial release with core TW3 calculation logic.
