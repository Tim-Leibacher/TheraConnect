import android.os.Parcel
import android.os.Parcelable

data class DiagnosisItem(
    val diagnose: String,
    val medicaments: List<String>,
    val reason: String?
)  : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.createStringArrayList()!!,
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(diagnose)
        parcel.writeStringList(medicaments)
        parcel.writeString(reason)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DiagnosisItem> {
        override fun createFromParcel(parcel: Parcel): DiagnosisItem {
            return DiagnosisItem(parcel)
        }

        override fun newArray(size: Int): Array<DiagnosisItem?> {
            return arrayOfNulls(size)
        }
    }
}
