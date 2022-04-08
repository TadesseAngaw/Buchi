fun getOutputFileName(flavor: String): String{
    val project = "pet-finder"
    val SEP = "_"
    val current = java.time.LocalDateTime.now()

    val formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val formattedDate = current.format(formatter)

    return  project + SEP + flavor + SEP + "v" + PetFinderApp.versionName + SEP + formattedDate + ".apk"
}