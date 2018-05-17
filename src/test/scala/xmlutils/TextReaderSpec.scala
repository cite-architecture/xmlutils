package edu.holycross.shot.xmlutils
import org.scalatest.FlatSpec

class TextReaderSpec extends FlatSpec {

val perioche3 = """
<div n="3" xmlns="http://www.tei-c.org/ns/1.0" xmlns:tei="http://www.tei-c.org/ns/1.0">  <head>Periocha III</head>  <p>Seditiones de agrariis legibus fuere. Capitolium ab exulibus et servis occupatum caesis his  receptum est. </p>
<p>Census bis actus est. Priore lustro censa sunt civium capita +VIII milia DCCXIIII+ praeter  orbos orbasque, sequenti CXVII milia CCXVIIII. </p>
 </div>
"""

  "The TextReader object" should "read some text" in {
    val textOnly = TextReader.collectText(perioche3)
    println(textOnly)
    val expected = "Periocha III Seditiones de agrariis legibus fuere. Capitolium ab exulibus et servis occupatum caesis his receptum est. Census bis actus est. Priore lustro censa sunt civium capita +VIII milia DCCXIIII+ praeter orbos orbasque, sequenti CXVII milia CCXVIIII."
    assert(textOnly == expected)
  }

}
