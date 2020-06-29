
package html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
/*1.2*/import models.MusicProduct

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Option[List[MusicProduct]],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(maybeProducts: Option[List[MusicProduct]], errorMsg: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.63*/("""

"""),format.raw/*5.1*/("""<html>
<head>
    <style>
        th, td """),format.raw/*8.16*/("""{"""),format.raw/*8.17*/("""
                """),format.raw/*9.17*/("""text-align:center;
                border:1px solid black;
                padding:5px
            """),format.raw/*12.13*/("""}"""),format.raw/*12.14*/("""
    """),format.raw/*13.5*/("""</style>
</head>
<body>
<title>Music shop - Search engine frontend</title>

<form action="http://localhost:7001/search/" method="get" enctype="multipart/form-data">
    <input type="text" name="search">
    <button type="submit" id="searchBtn">Search</button>
</form>

<p><a href="http://localhost:7001/search/guitar">Search Guitars</a></p>
<p><a href="http://localhost:7001/search-category/guitars">Search Guitars Category</a></p>
<p><a href="http://localhost:7001/search-category/drums">Search Drums Category</a></p>
<p><a href="http://localhost:7001/all-products">View All Products</a></p>

<br/>

"""),_display_(/*30.2*/maybeProducts/*30.15*/ match/*30.21*/ {/*31.3*/case Some(products) =>/*31.25*/ {_display_(Seq[Any](format.raw/*31.27*/("""
    """),format.raw/*32.5*/("""<h3>Search Results</h3>
      <table>
          <tr><th style="width:160px">Name</th>
              <th style="width:190px">Description</th>
              <th style="width:140px">Cost</th>
          </tr>
          """),_display_(/*38.12*/for(product <- products) yield /*38.36*/ {_display_(Seq[Any](format.raw/*38.38*/("""
              """),format.raw/*39.15*/("""<tr><td>"""),_display_(/*39.24*/product/*39.31*/.name),format.raw/*39.36*/("""</td>
                  <td>"""),_display_(/*40.24*/product/*40.31*/.description),format.raw/*40.43*/("""</td>
                  <td>"""),_display_(/*41.24*/product/*41.31*/.price),format.raw/*41.37*/("""</td>
              </tr>
          """)))}),format.raw/*43.12*/("""
      """),format.raw/*44.7*/("""</table>

  """)))}/*47.3*/case None =>/*47.15*/ {_display_(Seq[Any](format.raw/*47.17*/("""
    """),format.raw/*48.5*/("""<p>There were no products found matching your search criteria</p>
  """)))}}),format.raw/*50.2*/("""

"""),_display_(/*52.2*/if(errorMsg != "")/*52.20*/ {_display_(Seq[Any](format.raw/*52.22*/("""
    """),format.raw/*53.5*/("""<h5>Error: errorMsg</h5>
""")))}),format.raw/*54.2*/("""

"""),format.raw/*56.1*/("""</body>
</html>"""))
      }
    }
  }

  def render(maybeProducts:Option[List[MusicProduct]],errorMsg:String): play.twirl.api.HtmlFormat.Appendable = apply(maybeProducts,errorMsg)

  def f:((Option[List[MusicProduct]],String) => play.twirl.api.HtmlFormat.Appendable) = (maybeProducts,errorMsg) => apply(maybeProducts,errorMsg)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-05-04T10:35:27.129
                  SOURCE: C:/Users/YS1607131010/Desktop/music-shop-app-frontend/src/main/twirl/index.scala.html
                  HASH: ef72209a1efd9e052fcf59ee035468d3c38eedd4
                  MATRIX: 263->1|621->32|777->93|807->97|878->141|906->142|951->160|1081->262|1110->263|1143->269|1788->888|1810->901|1825->907|1835->913|1866->935|1906->937|1939->943|2188->1165|2228->1189|2268->1191|2312->1207|2348->1216|2364->1223|2390->1228|2447->1258|2463->1265|2496->1277|2553->1307|2569->1314|2596->1320|2666->1359|2701->1367|2734->1386|2755->1398|2795->1400|2828->1406|2929->1479|2960->1484|2987->1502|3027->1504|3060->1510|3117->1537|3148->1541
                  LINES: 10->1|15->3|20->3|22->5|25->8|25->8|26->9|29->12|29->12|30->13|47->30|47->30|47->30|47->31|47->31|47->31|48->32|54->38|54->38|54->38|55->39|55->39|55->39|55->39|56->40|56->40|56->40|57->41|57->41|57->41|59->43|60->44|62->47|62->47|62->47|63->48|64->50|66->52|66->52|66->52|67->53|68->54|70->56
                  -- GENERATED --
              */
          