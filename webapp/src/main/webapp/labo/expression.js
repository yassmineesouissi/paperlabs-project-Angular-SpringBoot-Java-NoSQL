


var cinexpression = /^[0-9]{8}$/

var testcin = (str) => {
console.log(str + "  gives " + cinexpression.test(str));}


testcin("ABC")
testcin("123456789")

testcin("12345678")
testcin("1234567")
