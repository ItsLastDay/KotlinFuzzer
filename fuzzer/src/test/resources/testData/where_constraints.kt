fun <P> funTypeParameterWithTwoUpperBounds() where P : Foo, P : Bar = 17
interface Some<T : First> where T : Some<T>
public val <T> T.extWithTwoUpperBounds: Int where T : CharSequence, T : Number