import java.util.*
fun box(): String {
listOf(ArrayList::class, LinkedList::class, AbstractList::class, (HashSet)?::class, TreeSet::class, HashMap::class, TreeMap::class, AbstractMap::class, box.(SimpleEntry)?::class).map({it.members.map(Any::toString)})
return "OK"
}