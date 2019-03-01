package edu.holycross.shot.xmlutils


import java.text.Normalizer
import scala.xml._

/** */
object TextReader {

  /** Recursively collect contents of all text-node
  * descendants of a given node.
  * @param n Node to collect from.
  * @param buff Buffer for collecting text contents.
  * @return A single String with all text from n.
  */
  def collectText(n: xml.Node, s: String): String = {
    var buff = StringBuilder.newBuilder
    buff.append(s)
    n match {
      case t: xml.Text => {
        buff.append(t.text)
      }

      case e: xml.Elem => {
        for (ch <- e.child) {
          buff = new StringBuilder(collectText(ch, buff.toString))
        }
      }
    }
    buff.toString
  }



  /** Recursively collect contents of all text-node
  * descendants of a given node.
  * @param n Node to collect from.
  * @return A single String with all text from n.
  */
  def collectText(n: xml.Node): String = {
    collectText(n,"")
  }


  /** Recursively collect contents of all text node
  * contents for a well-formed XML fragment serialized as a String.
  * @param xmlString String with well formed XML.
  * @return A single String with all text contents from xmlString.
  */
  def collectText(xmlString: String): String = {
    val n = XML.loadString(xmlString)
    collectText(n,"").replaceAll("[\\s]+", " ").trim
  }


  def sanitize(s: String): String = {
    Normalizer.normalize(s,Normalizer.Form.NFC).trim.replaceAll("[ ]+"," ")
  }


  /** Recursively get list of code points for a String.
  *
  * @param s String to get codepoints for.
  * @param idx Index of codepoint to start from.
  * @param codepoints List of codepoints seen so fare.
  */
  def codeptList (s: String, idx : Int = 0, codepoints: List[Int] = Nil): List[Int] = {
    if (idx >= s.length) {
      codepoints.reverse
    } else {
      val cp = s.codePointAt(idx)
      codeptList(s, idx + java.lang.Character.charCount(cp), cp :: codepoints)
    }
  }
}
