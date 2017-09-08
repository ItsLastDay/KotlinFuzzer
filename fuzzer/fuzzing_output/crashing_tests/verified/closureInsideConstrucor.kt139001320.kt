open class KModel {
val Any.sourcesInfo: String
init {
 fun relativePath(psiFile: String): String {
 return psiFile;
 }
 sourcesInfo = relativePath("OK")
 }

}
fun KModel.box(): String {
return KModel().sourcesInfo
}