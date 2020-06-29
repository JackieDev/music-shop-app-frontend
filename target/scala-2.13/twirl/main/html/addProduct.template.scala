
package html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object addProduct extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(addMsg: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.18*/("""

"""),format.raw/*3.1*/("""<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
</head>
<body>

<form name="add-product" action="/add-product" method="post">
    <p>Id: <input type="number" name="id"/></p>
    <p>Name: <input type="text" name="name"/></p>
    <p>Description: <input type="text" name="des"/></p>
    <p>Price: <input type="text" name="price"/></p>
    <p>Category: <input type="text" name="cat"/></p>
    <button type="submit">Add</button>
</form>

"""),_display_(/*19.2*/if(addMsg != "")/*19.18*/ {_display_(Seq[Any](format.raw/*19.20*/("""
  """),format.raw/*20.3*/("""<h5>Add product result: addMsg</h5>
""")))}),format.raw/*21.2*/("""

"""),format.raw/*23.1*/("""</body>
</html>"""))
      }
    }
  }

  def render(addMsg:String): play.twirl.api.HtmlFormat.Appendable = apply(addMsg)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (addMsg) => apply(addMsg)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-05-17T09:44:50.697
                  SOURCE: C:/Users/YS1607131010/Desktop/music-shop-app-frontend/src/main/twirl/addProduct.scala.html
                  HASH: 5070a6d8081236ca3aa1efb4063d52798f5bb074
                  MATRIX: 565->1|676->17|706->21|1216->505|1241->521|1281->523|1312->527|1380->565|1411->569
                  LINES: 14->1|19->1|21->3|37->19|37->19|37->19|38->20|39->21|41->23
                  -- GENERATED --
              */
          