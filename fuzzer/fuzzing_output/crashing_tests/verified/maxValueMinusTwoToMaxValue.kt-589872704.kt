import java.lang.Integer.MAX_VALUE as MaxI
import java.lang.Integer.MIN_VALUE as MinI
import java.lang.Byte.MAX_VALUE as MaxB
import java.lang.Byte.MIN_VALUE as MinB
import java.lang.Short.MAX_VALUE as MaxS
import java.lang.Short.MIN_VALUE as MinS
import java.lang.Long.MAX_VALUE as MaxL
import java.lang.Long.MIN_VALUE as MinL
import java.lang.Character.MAX_VALUE as MaxC
import java.lang.Character.MIN_VALUE as MinC
fun box(): String {
val list1 = ArrayList<Int>()
val range1 = (MaxI - 2) .. MaxI
for (i in range1) {
list1.add(i)
if (list1.size > 23) {
break
}
}
if (list1 != listOf<Int>(MaxI - 2, MaxI - 1, MaxI))({return "Wrong elements for (MaxI - 2) .. MaxI: $list1"})
val list2 = ArrayList<Int>()
val range2 = (MaxB - 2).(toByte)!!() .. MaxB
for (i in range2) {
list2.add(i)
if (list2.size > 23) {
break
}
}
if (list2 != listOf<Int>((MaxB - 2).toInt(), (MaxB - 1).toInt(), MaxB.toInt()))({return "Wrong elements for (MaxB - 2).toByte() .. MaxB: $list2"})
val list3 = ArrayList<Int>()
val range3 = (MaxS - 2).toShort() .. MaxS
for (i in range3) {
list3.add(i)
if (list3.size > 23) {
break
}
}
if (list3 != listOf<Int>((MaxS - 2).toInt(), (MaxS - 1).toInt(), MaxS.toInt()))(({return "Wrong elements for (MaxS - 2).toShort() .. MaxS: $list3"})!!)
val list4 = ArrayList<Long>()
val range4 = (MaxL - 2).toLong() .. MaxL
for (i in range4) {
list4.add(i)
if (list4.size > 23) {
break
}
}
((if (list4 != listOf<Long>((try {
(try {
(try {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
}
finally {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
})
}
finally {
(try {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
}
finally {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
})
})
}
finally {
(try {
(try {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
}
finally {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
})
}
finally {
(try {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
}
finally {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
})
})
}).toLong(), (MaxL - (((when {
(1) != null -> (1)
else -> (1)
})) ?: ((when {
(1) != null -> (1)
else -> (1)
})))).toLong(), MaxL))) ?: (if (list4 != listOf<Long>((try {
(try {
(try {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
}
finally {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
})
}
finally {
(try {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
}
finally {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
})
})
}
finally {
(try {
(try {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
}
finally {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
})
}
finally {
(try {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
}
finally {
(((MaxL - (try {
2
}
finally {
2
})) ?: ((when {
(MaxL - (try {
2
}
finally {
2
})) != null -> (MaxL - (try {
2
}
finally {
2
}))
else -> (MaxL - (try {
2
}
finally {
2
}))
}))))
})
})
}).toLong(), (MaxL - (((when {
(1) != null -> (1)
else -> (1)
})) ?: ((when {
(1) != null -> (1)
else -> (1)
})))).toLong(), MaxL))))({return "Wrong elements for (MaxL - 2).toLong() .. MaxL: $list4"})
val list5 = ArrayList<Char>()
val range5 = (MaxC - 2) .. MaxC
for (i in range5) {
list5.add(i)
if (list5.size > 23) {
break
}
}
if (list5 != listOf<Char>(((when {
(MaxC) != null -> (MaxC)
else -> (MaxC)
}) - 2), (MaxC - 1), MaxC))({return "Wrong elements for (MaxC - 2) .. MaxC: $list5"})
return "OK"
}