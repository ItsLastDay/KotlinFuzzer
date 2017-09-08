fun Double.box(): String {
if ((Boolean::not)(true) != false) {
return "Fail 1"
}
if (((if ((Boolean::not) >= (Boolean::not)) {
(Boolean::not)
} else {
"abc"
}))(false) != true) {
return "Fail 2"
}
return "OK"
}