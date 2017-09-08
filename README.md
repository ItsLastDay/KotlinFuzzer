# Kotlin Fuzzer
Fuzzer for Kotlin compiler. Found > 65 unique bugs in `kotlinc` v1.1.4-3.  

Fuzzer produced .kt files by mutating `kotlinc` test suite. If, when compiling the file, `kotlinc` threw an exception, we considered this a compiler bug.  
All files that crash the compiler are presented [here](https://github.com/ItsLastDay/KotlinFuzzer/tree/master/fuzzer/fuzzing_output/crashing_tests/verified).

## List of bugs
Full list of bugs can be found [here](https://github.com/ItsLastDay/KotlinFuzzer/blob/master/fuzzer/logs/current_grouping.txt). Currently, it starts as follows:
```
66
1, KotlinTypeMapper.java:130,	at org.jetbrains.kotlin.codegen.ExpressionCodegen.genQualified(ExpressionCodegen.java:323),	at org.jetbrains.kotlin.codegen.ExpressionCodegen.genQualified(ExpressionCodegen.java:289),	at org.jetbrains.kotlin.codegen.ExpressionCodegen.gen(ExpressionCodegen.java:329),	Caused by: java.lang.IllegalStateException: Error type encountered: [ERROR : <ERROR FUNCTION RETURN TYPE>] (ErrorType).,	at org.jetbrains.kotlin.codegen.state.KotlinTypeMapper$1.processErrorType(KotlinTypeMapper.java:130),	at org.jetbrains.kotlin.load.kotlin.TypeSignatureMappingKt.mapType(typeSignatureMapping.kt:111),	at org.jetbrains.kotlin.codegen.state.KotlinTypeMapper.mapType(KotlinTypeMapper.java:454)
	kt6990.kt-1463450686.kt
1, KotlinTypeMapper.java:130,	at org.jetbrains.kotlin.codegen.ExpressionCodegen.genQualified(ExpressionCodegen.java:323),	at org.jetbrains.kotlin.codegen.ExpressionCodegen.genQualified(ExpressionCodegen.java:289),	at org.jetbrains.kotlin.codegen.ExpressionCodegen.visitParenthesizedExpression(ExpressionCodegen.java:445),	Caused by: java.lang.IllegalStateException: Error type encountered: [ERROR : Unsubstituted type for <ERROR CLASS>] (ErrorType).,	at org.jetbrains.kotlin.codegen.state.KotlinTypeMapper$1.processErrorType(KotlinTypeMapper.java:130),	at org.jetbrains.kotlin.load.kotlin.TypeSignatureMappingKt.mapType(typeSignatureMapping.kt:111),	at org.jetbrains.kotlin.codegen.state.KotlinTypeMapper.mapType(KotlinTypeMapper.java:454)
	equalsHashCodeToString.kt-1975246039.kt
```  
The list is organized so:
- first comes the number of unique bugs
- then, each bug is described
  - `N`, the number of files that trigger the bug, is written
  - then, some description of the bug is shown. It is a snippet from full kotlinc stacktrace (with some parts possibly omitted, so that source-specific information is deleted)
  - the following `N` lines show names of files that trigger this bug, **in ascending order of size**

## How to run
From the `fuzzer` folder, run `run_current_main.sh` to start fuzzing.  
To update the list of bugs, run `update_all.sh.`
