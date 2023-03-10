package pt.ulusofona.cm.kotlin.challenge.models

import java.text.DecimalFormat
import java.util.*


class DateFormat {
    companion object {
        fun getAge(dataDeNascimento: Date?): Int {
            val cal: Calendar = GregorianCalendar()

            cal.time = dataDeNascimento

            val year = cal[Calendar.YEAR] - 1900

            val month = cal[Calendar.MONTH] - 1

            val day = cal[Calendar.DAY_OF_MONTH]

            var date: Date = Date(year, month, day)

            val today = Calendar.getInstance()

            val birthDate = Calendar.getInstance()

            var age = 0

            birthDate.time = date

            print(date)

            require(!birthDate.after(today)) { "ERRO" }
            age = today[Calendar.YEAR] - birthDate[Calendar.YEAR]

            if (birthDate[Calendar.DAY_OF_YEAR] - today[Calendar.DAY_OF_YEAR] > 3 ||
                birthDate[Calendar.MONTH] > today[Calendar.MONTH]
            ) {
                age--

            } else if (birthDate[Calendar.MONTH] == today[Calendar.MONTH] &&
                birthDate[Calendar.DAY_OF_MONTH] > today[Calendar.DAY_OF_MONTH]
            ) {
                age--
            }
            return age
        }

        fun getDate(dataDeNascimento: Date?): String {
            val mFormat = DecimalFormat("00")

            val cal2: Calendar = GregorianCalendar()

            cal2.time = dataDeNascimento

            val year = cal2[Calendar.YEAR]

            val month = cal2[Calendar.MONTH] + 1

            val day = cal2[Calendar.DAY_OF_MONTH]

            return "${mFormat.format(java.lang.Double.valueOf(day.toDouble()))}-${
                mFormat.format(
                    java.lang.Double.valueOf(
                        month.toDouble()
                    )
                )
            }-${mFormat.format(java.lang.Double.valueOf(year.toDouble()))}"
        }
    }

}
