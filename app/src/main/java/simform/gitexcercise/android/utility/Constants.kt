package simform.gitexcercise.android.utility

object StrongPasswordPattern {
    const val NUMBER = "^(?=.*[0-9])"
    const val SMALL_ALPHABET = "^(?=.*[a-z])"
    const val CAPITAL_ALPHABET = "^(?=.*[A-Z])"
    const val SPECIAL_CHARACTER = "^(?=.*[@#\$%^&+=])"
    const val LENGTH = "^(?=\\S+$).{8,20}$"
}
