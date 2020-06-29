
package html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
/*1.2*/import models.MusicProduct

object results extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Option[MusicProduct],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(product: Option[MusicProduct], errorMsg: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.51*/("""

"""),format.raw/*5.1*/("""<html>
<body>
<title>Music shop - Search engine frontend</title>

<form action="http://localhost:7001/search/guitar" method="get" enctype="multipart/form-data">
    <input type="text" name="search">
    <button type="submit" id="searchBtn">Search</button>
</form>

<p><a href="http://localhost:7001/search/guitar">Search Guitars</a></p>

"""),_display_(/*16.2*/product/*16.9*/ match/*16.15*/ {/*17.3*/case Some(p) =>/*17.18*/ {_display_(Seq[Any](format.raw/*17.20*/("""
    """),format.raw/*18.5*/("""<h5>Search Result</h5>
      <ul>
        <li>Name: p.name, Description: p.description, Cost: p.price</li>
      </ul>
  """)))}/*24.3*/case None =>/*24.15*/ {_display_(Seq[Any](format.raw/*24.17*/("""
    """),format.raw/*25.5*/("""<p>There were no products found matching your search criteria</p>
   """)))}}),format.raw/*27.2*/("""

"""),_display_(/*29.2*/if(errorMsg != "")/*29.20*/ {_display_(Seq[Any](format.raw/*29.22*/("""
  """),format.raw/*30.3*/("""<h5>Error: errorMsg</h5>
""")))}),format.raw/*31.2*/("""

"""),format.raw/*33.1*/("""</body>
</html>"""))
      }
    }
  }

  def render(product:Option[MusicProduct],errorMsg:String): play.twirl.api.HtmlFormat.Appendable = apply(product,errorMsg)

  def f:((Option[MusicProduct],String) => play.twirl.api.HtmlFormat.Appendable) = (product,errorMsg) => apply(product,errorMsg)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-05-03T12:36:00.577
                  SOURCE: C:/Users/YS1607131010/Desktop/music-shop-app-frontend/src/main/twirl/results.scala.html
                  HASH: 26df17a08e90908f57cba8f17d1a99657807574f
                  MATRIX: 263->1|617->32|761->81|791->85|1167->435|1182->442|1197->448|1207->454|1231->469|1271->471|1304->477|1448->609|1469->621|1509->623|1542->629|1644->703|1675->708|1702->726|1742->728|1773->732|1830->759|1861->763
                  LINES: 10->1|15->3|20->3|22->5|33->16|33->16|33->16|33->17|33->17|33->17|34->18|38->24|38->24|38->24|39->25|40->27|42->29|42->29|42->29|43->30|44->31|46->33
                  -- GENERATED --
              */
          